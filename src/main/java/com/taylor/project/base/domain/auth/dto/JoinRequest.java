package com.taylor.project.base.domain.auth.dto;

import com.taylor.project.base.common.constant.enumtype.Device;
import jakarta.validation.constraints.NotNull;

public record JoinRequest(
    @NotNull(message = "loginId 필수 값입니다.")
    String loginId,
    @NotNull(message = "loginPassword 필수 값입니다.")
    String loginPassword,
    @NotNull(message = "name 필수 값입니다.")
    String name,
    @NotNull(message = "phone 필수 값입니다.")
    String phone,
    String email,
    Device device,
    @NotNull(message = "memberGroupId 필수 값입니다.")
    Long memberGroupId

) {

}

