package com.taylor.project.base.domain.member.controller;

import com.taylor.project.base.common.response.ApiResponse;
import com.taylor.project.base.domain.member.dto.MemberGroupRequest;
import com.taylor.project.base.domain.member.dto.MemberGroupResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/group")
public class MemberGroupController {

    @PostMapping
    public ApiResponse<MemberGroupResponse> create(@Valid MemberGroupRequest memberGroupRequest) {
        return ApiResponse.success(null);
    }

}
