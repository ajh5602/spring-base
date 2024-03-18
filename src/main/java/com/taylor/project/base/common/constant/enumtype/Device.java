package com.taylor.project.base.common.constant.enumtype;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Device {

    AOS("android"),
    IOS("ios"),
    WEB("web"),
    ;

    final String value;

}
