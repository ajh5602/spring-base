package com.taylor.project.base.domain.member.dto;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public record MemberSearchRequest(
    String phone,
    String email,
    @DateTimeFormat(iso = ISO.DATE_TIME)
    LocalDateTime startDateTime,
    @DateTimeFormat(iso = ISO.DATE_TIME)
    LocalDateTime endDateTime
) {

}
