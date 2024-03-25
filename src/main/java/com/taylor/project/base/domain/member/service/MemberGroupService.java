package com.taylor.project.base.domain.member.service;

import com.taylor.project.base.common.response.ApiPage;
import com.taylor.project.base.common.response.ApiPageRequest;
import com.taylor.project.base.domain.member.dto.MemberGroupRequest;
import com.taylor.project.base.domain.member.dto.MemberGroupResponse;
import com.taylor.project.base.domain.member.mapper.MemberGroupMapper;
import com.taylor.project.base.entity.MemberGroup;
import com.taylor.project.base.repository.MemberGroupRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberGroupService {

    private final MemberGroupRepository memberGroupRepository;

    public MemberGroupResponse create(MemberGroupRequest request) {
        return null;
    }

    public ApiPage<List<MemberGroupResponse>> getMemberGroupByName(String name,
        ApiPageRequest page) {
        Page<MemberGroup> memberGroups = memberGroupRepository.findByNameLikeAndDeletedYn(name,
            false, page.of());
        
        List<MemberGroupResponse> responses = memberGroups.getContent().stream()
            .map(MemberGroupMapper.instance::toMemberGroupResponse)
            .toList();

        return ApiPage.<List<MemberGroupResponse>>builder()
            .content(responses)
            .page(memberGroups)
            .build();
    }

    public MemberGroupResponse getMemberGroupByMemberId(Long memberId) {
        return null;
    }

}
