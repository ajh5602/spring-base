package com.taylor.project.base.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

@Getter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiPage<V> {

    final V content;
    final ApiPageable pageable;

    public ApiPage(V content, Page<?> page) {
        this.content = content;
        this.pageable = ApiPageable.builder()
            .offset(page.getPageable().getOffset() + 1L)
            .pageNumber((long) page.getPageable().getPageNumber() + 1L)
            .pageSize((long) page.getSize())
            .pageElements((long) page.getNumberOfElements())
            .totalElements(page.getTotalElements())
            .build();
    }
}
