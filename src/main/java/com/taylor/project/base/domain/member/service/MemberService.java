package com.taylor.project.base.domain.member.service;

import com.taylor.project.base.common.exception.ApiException;
import com.taylor.project.base.common.exception.ApiExceptionCode;
import com.taylor.project.base.common.response.ApiPage;
import com.taylor.project.base.common.response.ApiPageRequest;
import com.taylor.project.base.domain.auth.dto.JoinRequest;
import com.taylor.project.base.domain.member.dto.MemberDto;
import com.taylor.project.base.domain.member.dto.MemberResponse;
import com.taylor.project.base.domain.member.dto.MemberSearchRequest;
import com.taylor.project.base.domain.member.dto.MemberUpdateRequest;
import com.taylor.project.base.domain.member.mapper.MemberMapper;
import com.taylor.project.base.entity.Member;
import com.taylor.project.base.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member create(MemberDto memberDto) {
        Member member = MemberMapper.instance.toMember(memberDto);
        return memberRepository.save(member);
    }

    public MemberResponse update(MemberUpdateRequest request) {
        return null;
    }

    public void logout(Long memberId) {

    }

    public void dormant(Long memberId) {

    }

    public void withdraw(Long memberId) {

    }

    public ApiPage<List<MemberResponse>> getMemberByMemberSearchRequest(MemberSearchRequest search,
        ApiPageRequest pageRequest) {
        return null;
    }

    public MemberResponse getMemberByMemberId(Long memberId) {
        return null;
    }

    public Member getMemberByLoginId(String loginId) {
        return memberRepository.findByLoginId(loginId)
            .orElseThrow(() -> new ApiException(ApiExceptionCode.NOT_FOUND_MEMBER));
    }

    public Boolean checkDuplicationMemberByJoinRequest(JoinRequest request) {
        List<Member> member = memberRepository.findByLoginIdOrPhoneOrEmail(request.loginId(),
                request.phone(), request.email())
            .stream().filter((m) -> m.getWithdrawYn().equals(false))
            .toList();

        return !member.isEmpty();
    }

}
