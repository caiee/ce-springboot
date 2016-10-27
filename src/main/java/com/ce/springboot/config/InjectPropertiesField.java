package com.ce.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author caie
 * @since 16/9/1
 */
@Configuration
@PropertySource("classpath:config.properties")
public class InjectPropertiesField {

    @Value("${VALIDCODE_URL}")
    private String PAY_URL;

    public String getPAY_URL() {
        return PAY_URL;
    }
}
