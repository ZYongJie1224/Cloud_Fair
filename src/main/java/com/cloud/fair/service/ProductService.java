package com.cloud.fair.service;

import com.cloud.fair.entity.Product;
import java.util.List;

public interface ProductService {
    boolean add(Product product);
    boolean delete(Long id);
    boolean update(Product product);
    Product getById(Long id);
    List<Product> getAll();
    boolean existsByCustomCode(String customCode);
    boolean existsByCustomCodeExcludeId(String customCode, Long id);
}
