package com.taylor.project.base.domain.auth.service;

import com.taylor.project.base.domain.auth.dto.JoinRequest;
import com.taylor.project.base.domain.auth.dto.LoginRequest;
import com.taylor.project.base.domain.auth.dto.LoginResponse;
import com.taylor.project.base.domain.member.dto.MemberRequest;
import com.taylor.project.base.domain.member.service.MemberService;
import com.taylor.project.base.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberService memberService;

    public void join(JoinRequest request) {

        MemberRequest memberRequest = null;
        memberService.create(memberRequest);
    }

    public LoginResponse login(LoginRequest request) {
        Member member = memberService.getMemberByLoginId(request.loginId());
        return null;
    }


}
