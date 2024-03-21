package com.taylor.project.base.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.taylor.project.base.common.exception.ApiExceptionCode;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    final Boolean result;

    final String message;

    final T data;

    public static <T> ApiResponse<T> success(T data) {
        ApiResponseBuilder<T> builder = ApiResponse.<T>builder().result(true);
        return data instanceof String ? builder.message(data.toString()).build()
            : builder.data(data).build();
    }

    public static <T> ResponseEntity<ApiResponse<T>> fail(ApiExceptionCode code) {
        return ResponseEntity.status(200)
            .body(ApiResponse.<T>builder().result(false).message(code.getMessage()).build());
    }

    public static <T> ResponseEntity<ApiResponse<T>> fail(String message) {
        return ResponseEntity.status(200)
            .body(ApiResponse.<T>builder().result(false).message(message).build());
    }

    public static <T> ResponseEntity<ApiResponse<T>> serverException(String message) {
        return ResponseEntity.status(500)
            .body(ApiResponse.<T>builder().result(false).message(message).build());
    }
}
