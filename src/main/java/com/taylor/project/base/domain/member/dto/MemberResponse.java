package com.taylor.project.base.domain.member.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.taylor.project.base.common.constant.enumtype.Device;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberResponse {

    Long id;

    String name;

    String phone;

    String email;

    Device device;

}
