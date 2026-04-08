package com.cloud.fair.mapper;

import com.cloud.fair.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ProductMapper {
    int insert(Product product);
    int deleteById(Long id);
    int update(Product product);
    Product selectById(Long id);
    List<Product> selectAll();
}