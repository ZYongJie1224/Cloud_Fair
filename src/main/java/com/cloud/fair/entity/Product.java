package com.cloud.fair.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product {
    private Long id;
    private String customCode;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String imageUrl;
    private String category;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}