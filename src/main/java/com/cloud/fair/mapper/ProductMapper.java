package com.cloud.fair.mapper;

import com.cloud.fair.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ProductMapper {
    int insert(Product product);
    int deleteById(Long id);
    int update(Product product);
    Product selectById(Long id);
    List<Product> selectAll();
    Long selectIdByCustomCode(@Param("customCode") String customCode);
    Long selectIdByCustomCodeExcludeId(@Param("customCode") String customCode, @Param("id") Long id);
}
