package com.chrt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义区域解析器
 * @author chrt
 * @version 1.0.0
 */
@Configuration
public class MyLocaleResolver implements LocaleResolver {
    /**
     * 返回国际化对象
     * 默认为zh_CN
     * @param httpServletRequest 请求
     * @return Locale
     */
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String accept_language = httpServletRequest.getHeader("Accept-Language");
        String language = httpServletRequest.getParameter("language");
        String[] split = (language != null && !"".equals(language)) ? language.split("-") : accept_language.split(",")[0].split("-");
        return new Locale(split[0], split[1]);
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

    /**
     * 将国际化对象添加到Bean中
     * @return 自定义的国际化对象
     */
    @Bean
    public LocaleResolver getLocaleResolver() {
        return new MyLocaleResolver();
    }
}
