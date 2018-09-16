package com.edu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date ToDate(String datetime) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(datetime);
    }

    public static String DateateToString(Date datetime) {
        SimpleDateFormat format = new SimpleDateFormat();
        return format.format(datetime);
    }
}
