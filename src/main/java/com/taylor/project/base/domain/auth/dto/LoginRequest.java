package com.taylor.project.base.domain.auth.dto;

public record LoginRequest(
    String loginId,
    String loginPassword
) {

}
