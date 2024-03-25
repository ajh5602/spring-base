package com.taylor.project.base.domain.member.service;

import com.taylor.project.base.common.response.ApiPage;
import com.taylor.project.base.common.response.ApiPageRequest;
import com.taylor.project.base.domain.member.dto.MemberGroupRequest;
import com.taylor.project.base.domain.member.dto.MemberGroupResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberGroupService {

    public MemberGroupResponse create(MemberGroupRequest request) {
        return null;
    }

    public ApiPage<List<MemberGroupResponse>> getMemberGroupByName(String name,
        ApiPageRequest page) {
        return null;
    }

    public MemberGroupResponse getMemberGroupByMemberId(Long memberId) {
        return null;
    }

}
