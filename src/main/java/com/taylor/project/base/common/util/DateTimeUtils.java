package com.taylor.project.base.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeUtils {

    public static String getDateTime(LocalDateTime localDateTime) {
        return getDateTimeByPattern(localDateTime, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateTimeDay(LocalDateTime localDateTime) {
        return getDateTimeByPattern(localDateTime, "MM월 dd일 (E) HH:mm");
    }

    private static String getDateTimeByPattern(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern, Locale.KOREAN));
    }

}
