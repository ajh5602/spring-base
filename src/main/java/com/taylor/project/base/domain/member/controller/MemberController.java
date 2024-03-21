package com.taylor.project.base.domain.member.controller;

import com.taylor.project.base.common.response.ApiPage;
import com.taylor.project.base.common.response.ApiPageRequest;
import com.taylor.project.base.common.response.ApiResponse;
import com.taylor.project.base.domain.member.dto.MemberRequest;
import com.taylor.project.base.domain.member.dto.MemberResponse;
import com.taylor.project.base.domain.member.dto.MemberSearchRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    @PostMapping("/{memberId}/logout")
    public ApiResponse<String> logout(@PathVariable("memberId") Long memberId) {
        return ApiResponse.success(null);
    }

    @PatchMapping("/{memberId}/dormant")
    public ApiResponse<String> dormant(@PathVariable("memberId") Long memberId) {
        return ApiResponse.success(null);
    }

    @PatchMapping("/{memberId}/withdraw")
    public ApiResponse<String> withdraw(@PathVariable("memberId") Long memberId) {
        return ApiResponse.success(null);
    }

    @GetMapping("/{memberId}")
    public ApiResponse<MemberResponse> memberByMemberId(@PathVariable("memberId") Long memberId) {
        return ApiResponse.success(null);
    }

    @GetMapping
    public ApiResponse<ApiPage<MemberResponse>> memberByPage(@Valid MemberSearchRequest search,
        @Valid ApiPageRequest page) {
        return ApiResponse.success(null);
    }

    @PutMapping
    public ApiResponse<MemberResponse> update(@Valid @RequestBody MemberRequest request) {
        return ApiResponse.success(null);
    }

}
