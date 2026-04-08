package com.cloud.fair.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 获取项目运行的当前目录下的 uploads 文件夹
        String path = System.getProperty("user.dir") + "/uploads/";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs(); // 如果文件夹不存在则创建
        }
        // 将 /uploads/** 的请求映射到本地的 uploads 文件夹
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + path);
    }
}