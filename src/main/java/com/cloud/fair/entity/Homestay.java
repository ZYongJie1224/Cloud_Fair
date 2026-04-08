package com.cloud.fair.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Homestay {
    private Long id;
    private String customCode;
    private String name;
    private String description;
    private BigDecimal pricePerNight;
    private String address;
    private String imageUrl;
    private String contactPhone;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}