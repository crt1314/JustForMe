package com.chrt.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {

    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String shortDateFormat = "yyyy-MM-dd";

    @Override
    public Date convert(String s) {
        if (StringUtils.isEmpty(s)) {
            return null;
        }
        s = s.trim();
        try {
            if (s.contains("-")) {
                SimpleDateFormat sdf = (s.contains(":")) ? new SimpleDateFormat(dateFormat) : new SimpleDateFormat(shortDateFormat);
                return sdf.parse(s);
            } else if (s.matches("^\\d+$")) {
                Long lDate = new Long(s);
                return new Date(lDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
