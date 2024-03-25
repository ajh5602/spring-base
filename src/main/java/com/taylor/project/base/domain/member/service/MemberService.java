package com.taylor.project.base.domain.member.service;

import com.taylor.project.base.common.exception.ApiException;
import com.taylor.project.base.common.exception.ApiExceptionCode;
import com.taylor.project.base.common.response.ApiPage;
import com.taylor.project.base.common.response.ApiPageRequest;
import com.taylor.project.base.domain.member.dto.MemberDto;
import com.taylor.project.base.domain.member.dto.MemberResponse;
import com.taylor.project.base.domain.member.dto.MemberSearchRequest;
import com.taylor.project.base.domain.member.dto.MemberUpdateRequest;
import com.taylor.project.base.domain.member.mapper.MemberMapper;
import com.taylor.project.base.entity.Member;
import com.taylor.project.base.entity.MemberGroup;
import com.taylor.project.base.repository.MemberGroupRepository;
import com.taylor.project.base.repository.MemberRepository;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberGroupRepository memberGroupRepository;

    @Transactional
    public Member create(MemberDto memberDto) {
        Member member = MemberMapper.instance.toMember(memberDto);
        return memberRepository.save(member);
    }

    @Transactional
    public MemberResponse update(MemberUpdateRequest request) {
        Member member = getMemberById(request.memberId());

        if (checkDuplicationMember(null, request.phone(), request.email())) {
            throw new ApiException(ApiExceptionCode.DUPLICATION_MEMBER);
        }

        if (Objects.nonNull(request.memberGroupId())) {
            MemberGroup memberGroup = memberGroupRepository.findById(request.memberGroupId())
                .orElseThrow(() -> new ApiException(ApiExceptionCode.NOT_FOUND_MEMBER_GROUP));
            member.setMemberGroup(memberGroup);
        }

        member.setPhone(request.phone());
        member.setEmail(request.email());
        member.setDevice(request.device());

        memberRepository.save(member);
        return MemberMapper.instance.toMemberResponse(member);
    }

    public void logout(Long memberId) {
        //TODO : JWT를 활용한 로그인 기능 개발 이후 로그아웃 개발 예정
    }

    @Transactional
    public void dormant(Long memberId) {
        Member member = getMemberById(memberId);
        member.setDormantYn(true);
        memberRepository.save(member);
    }

    @Transactional
    public void withdraw(Long memberId) {
        Member member = getMemberById(memberId);
        member.setWithdrawYn(true);
        member.setWithdrawDateTime();
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public ApiPage<List<MemberResponse>> getMemberByMemberSearchRequest(MemberSearchRequest search,
        ApiPageRequest pageRequest) {
        Page<Member> members = memberRepository.findByMemberSearchRequest(search, pageRequest.of());

        List<MemberResponse> contents = members.getContent().stream()
            .map(MemberMapper.instance::toMemberResponse)
            .toList();

        return ApiPage.<List<MemberResponse>>builder()
            .content(contents)
            .page(members)
            .build();
    }

    @Transactional(readOnly = true)
    public MemberResponse getMemberResponseById(Long memberId) {
        return MemberMapper.instance.toMemberResponse(getMemberById(memberId));
    }

    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId)
            .orElseThrow(() -> new ApiException(ApiExceptionCode.NOT_FOUND_MEMBER));
    }

    public Member getMemberByLoginId(String loginId) {
        return memberRepository.findByLoginId(loginId)
            .orElseThrow(() -> new ApiException(ApiExceptionCode.NOT_FOUND_LOGIN_ID));
    }

    public Boolean checkDuplicationMember(String loginId, String phone, String email) {
        return !memberRepository.findDuplicationMember(loginId, phone, email).isEmpty();
    }

}
