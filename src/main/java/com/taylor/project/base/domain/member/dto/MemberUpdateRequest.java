package com.taylor.project.base.domain.member.dto;

import com.taylor.project.base.common.constant.enumtype.Device;
import com.taylor.project.base.entity.MemberGroup;

public record MemberUpdateRequest(
    Device device,
    MemberGroup memberGroup
) {

}
