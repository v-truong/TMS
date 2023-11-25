package com.tms.commons;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.util.StringUtils;

public class TMSBeanPropertyRowMapper<T> extends BeanPropertyRowMapper<T> {

    public TMSBeanPropertyRowMapper(Class<T> mappedClass) {
        super(mappedClass);
    }

    @Override
    protected String underscoreName(String name) {
        if (!StringUtils.hasLength(name)) {
            return "";
        }

        String[] r = name.split("(?=\\p{Upper})|(?<=\\D)(?=\\d+\\b)");
        return String.join("_", r).toLowerCase();
    }
}
