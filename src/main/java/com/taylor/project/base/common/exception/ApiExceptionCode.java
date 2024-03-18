package com.taylor.project.base.common.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ApiExceptionCode {

    NOT_FOUND_DATA("NOT_FOUND_DATA", "해당 데이터를 찾을 수 없습니다."),
    ;

    final String code;
    final String message;
}
