package com.cloud.fair.service.impl;

import com.cloud.fair.entity.Product;
import com.cloud.fair.mapper.ProductMapper;
import com.cloud.fair.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public boolean add(Product product) { return productMapper.insert(product) > 0; }
    @Override
    public boolean delete(Long id) { return productMapper.deleteById(id) > 0; }
    @Override
    public boolean update(Product product) { return productMapper.update(product) > 0; }
    @Override
    public Product getById(Long id) { return productMapper.selectById(id); }
    @Override
    public List<Product> getAll() { return productMapper.selectAll(); }
}