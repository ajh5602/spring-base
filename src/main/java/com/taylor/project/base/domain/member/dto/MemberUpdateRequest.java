package com.taylor.project.base.domain.member.dto;

import com.taylor.project.base.common.constant.enumtype.Device;
import jakarta.validation.constraints.NotNull;

public record MemberUpdateRequest(
    @NotNull(message = "memberId 필수 값입니다.")
    Long memberId,
    String phone,
    String email,
    Device device,
    Long memberGroupId
) {

}
