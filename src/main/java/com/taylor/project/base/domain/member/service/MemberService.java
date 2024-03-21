package com.taylor.project.base.domain.member.service;

import com.taylor.project.base.common.response.ApiPage;
import com.taylor.project.base.common.response.ApiPageRequest;
import com.taylor.project.base.domain.member.dto.MemberRequest;
import com.taylor.project.base.domain.member.dto.MemberResponse;
import com.taylor.project.base.domain.member.dto.MemberSearchRequest;
import com.taylor.project.base.entity.Member;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    public MemberResponse create(MemberRequest request) {
        return null;
    }

    public MemberResponse update(MemberRequest request) {
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
        return null;
    }

}
