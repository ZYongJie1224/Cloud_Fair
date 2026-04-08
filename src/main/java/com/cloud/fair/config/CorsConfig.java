package com.cloud.fair.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 映射所有接口
        registry.addMapping("/**")
                // 允许所有来源（如果是 Spring Boot 2.4 及以上版本，必须使用 allowedOriginPatterns 代替 allowedOrigins）
                .allowedOriginPatterns("*")
                // 允许的请求方式
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")
                // 允许的请求头
                .allowedHeaders("*")
                // 是否允许携带 Cookie 等凭证信息
                .allowCredentials(true)
                // 预检请求（OPTIONS）的缓存时间，单位是秒，避免频繁发送 OPTIONS 请求
                .maxAge(3600);
    }
}