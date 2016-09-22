package com.ce.springboot.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    public FastJsonHttpMessageConverter4 customFastJsonHttpMessageConverter() {
        return new FastJsonHttpMessageConverter4();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customFastJsonHttpMessageConverter());
        super.addDefaultHttpMessageConverters(converters);
    }
}