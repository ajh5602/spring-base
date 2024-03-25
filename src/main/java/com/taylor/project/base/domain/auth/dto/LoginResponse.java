package com.taylor.project.base.domain.auth.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {

    Long id;

    String name;

    String email;

    String phone;

    Long memberGroupId;

    String memberGroupName;

    String token;

}
