package com.chrt.config;

import com.chrt.converter.StringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

/**
 * 用于添加字符串转变为Date的转换器
 * @author chrt
 * @version 1.0.0
 */
@Configuration
public class WebConfigBeans {
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @PostConstruct
    public void initEditableAviation() {
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
        if (initializer != null) {
            GenericConversionService conversionService = (GenericConversionService) initializer.getConversionService();
            if (conversionService != null) {
                conversionService.addConverter(new StringToDateConverter());
            }
        }
    }
}
