package com.taylor.project.base.domain.auth.dto;

public record JoinRequest(
    String loginId,
    String loginPassword,
    String name,
    String phone
) {

}

