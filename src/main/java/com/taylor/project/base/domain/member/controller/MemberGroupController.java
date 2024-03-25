package com.taylor.project.base.domain.member.controller;

import com.taylor.project.base.common.response.ApiPage;
import com.taylor.project.base.common.response.ApiPageRequest;
import com.taylor.project.base.common.response.ApiResponse;
import com.taylor.project.base.domain.member.dto.MemberGroupRequest;
import com.taylor.project.base.domain.member.dto.MemberGroupResponse;
import com.taylor.project.base.domain.member.service.MemberGroupService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member-groups")
public class MemberGroupController {

    private final MemberGroupService memberGroupService;

    @GetMapping("/{name}")
    public ApiResponse<ApiPage<List<MemberGroupResponse>>> memberGroupByName(
        @PathVariable("name") String name, ApiPageRequest page) {
        return ApiResponse.success(memberGroupService.getMemberGroupByName(name, page));
    }

    @GetMapping
    public ApiResponse<MemberGroupResponse> memberGroupByMemberId(
        @RequestParam("memberId") Long memberId) {
        return ApiResponse.success(memberGroupService.getMemberGroupByMemberId(memberId));
    }

    @PostMapping
    public ApiResponse<MemberGroupResponse> create(@Valid MemberGroupRequest request) {
        return ApiResponse.success(memberGroupService.create(request));
    }

}
