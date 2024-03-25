package com.taylor.project.base.domain.auth.dto;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(
    @NotNull(message = "loginId 필수 값입니다.")
    String loginId,
    @NotNull(message = "loginPassword 필수 값입니다.")
    String loginPassword
) {

}
