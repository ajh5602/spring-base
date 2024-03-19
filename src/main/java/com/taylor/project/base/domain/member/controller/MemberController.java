package com.taylor.project.base.domain.member.controller;

import com.taylor.project.base.common.response.ApiPageRequest;
import com.taylor.project.base.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    @GetMapping
    public ApiResponse<String> getMember(ApiPageRequest pageRequest) {
        return ApiResponse.success("");
    }


}
