package com.taylor.project.base.repository;

import static com.taylor.project.base.entity.QMember.member;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.taylor.project.base.domain.member.dto.MemberSearchRequest;
import com.taylor.project.base.entity.Member;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Member> findByMemberSearchRequest(MemberSearchRequest request,
        Pageable pageable) {
        JPQLQuery<Member> query = memberSearchRequestQuery(request);
        List<Member> contents = query.offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        return new PageImpl<>(contents, pageable, query.fetchCount());
    }

    private JPQLQuery<Member> memberSearchRequestQuery(MemberSearchRequest request) {
        return queryFactory.selectFrom(member)
            .where(likePhone(request.phone()),
                likeEmail(request.email()),
                betweenCreatedAt(request.startDateTime(), request.endDateTime()));
    }

    @Override
    public List<Member> findDuplicationMember(String loginId, String phone, String email) {
        return queryFactory.selectFrom(member)
            .where(member.withdrawYn.eq(false),
                equalLoginId(loginId),
                equalPhone(phone),
                equalEmail(email))
            .stream().toList();
    }

    private BooleanExpression equalLoginId(String loginId) {
        return StringUtils.hasText(loginId) ? member.loginId.eq(loginId) : null;
    }

    private BooleanExpression equalPhone(String phone) {
        return StringUtils.hasText(phone) ? member.phone.eq(phone) : null;
    }

    private BooleanExpression equalEmail(String email) {
        return StringUtils.hasText(email) ? member.email.contains(email) : null;
    }

    private BooleanExpression likePhone(String phone) {
        return StringUtils.hasText(phone) ? member.phone.contains(phone) : null;
    }

    private BooleanExpression likeEmail(String email) {
        return StringUtils.hasText(email) ? member.email.contains(email) : null;
    }

    private BooleanExpression betweenCreatedAt(LocalDateTime start, LocalDateTime end) {
        return Objects.nonNull(start) && Objects.nonNull(end)
            ? member.createdAt.between(start, end) : null;
    }

}
