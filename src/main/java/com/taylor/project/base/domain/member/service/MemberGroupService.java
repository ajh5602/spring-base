package com.taylor.project.base.domain.member.service;

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

    public List<MemberGroupResponse> getMemberGroupByName(String name) {
        return null;
    }

    public MemberGroupResponse getMemberGroupByMemberId(Long memberId) {
        return null;
    }


}
