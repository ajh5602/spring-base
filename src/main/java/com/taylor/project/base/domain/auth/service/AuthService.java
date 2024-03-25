package com.taylor.project.base.domain.auth.service;

import com.taylor.project.base.common.exception.ApiException;
import com.taylor.project.base.common.exception.ApiExceptionCode;
import com.taylor.project.base.domain.auth.dto.JoinRequest;
import com.taylor.project.base.domain.auth.dto.LoginRequest;
import com.taylor.project.base.domain.auth.dto.LoginResponse;
import com.taylor.project.base.domain.member.dto.MemberDto;
import com.taylor.project.base.domain.member.mapper.MemberMapper;
import com.taylor.project.base.domain.member.service.MemberGroupService;
import com.taylor.project.base.domain.member.service.MemberService;
import com.taylor.project.base.entity.Member;
import com.taylor.project.base.entity.MemberGroup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberService memberService;
    private final MemberGroupService memberGroupService;

    @Transactional
    public void join(JoinRequest request) {
        if (memberService.checkDuplicationMemberByJoinRequest(request)) {
            throw new ApiException(ApiExceptionCode.DUPLICATION_MEMBER_JOIN);
        }

        MemberGroup memberGroup = memberGroupService.getMemberGroupById(request.memberGroupId());
        MemberDto member = MemberMapper.instance.toJoinResponse(request);
        member.setMemberGroup(memberGroup);

        memberService.create(member);
    }

    public LoginResponse login(LoginRequest request) {
        Member member = memberService.getMemberByLoginId(request.loginId());

        return null;
    }


}
