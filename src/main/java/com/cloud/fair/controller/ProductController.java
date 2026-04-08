package com.cloud.fair.controller;

import com.cloud.fair.entity.Product;
import com.cloud.fair.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> getAll() { return productService.getAll(); }
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) { return productService.getById(id); }
    @PostMapping("/add")
    public String add(@RequestBody Product product) { return productService.add(product) ? "添加成功" : "添加失败"; }
    @PutMapping("/update")
    public String update(@RequestBody Product product) { return productService.update(product) ? "更新成功" : "更新失败"; }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) { return productService.delete(id) ? "删除成功" : "删除失败"; }
    @GetMapping("/front/list")
    public List<Product> getFrontList() {
        // 过滤出 status == 1 的民宿返回给前端
        return productService.getAll().stream()
                .filter(h -> h.getStatus() != null && h.getStatus() == 1)
                .collect(Collectors.toList());
    }

    @GetMapping("/front/detail/{id}")
    public Product getFrontDetail(@PathVariable Long id) {
        Product product = productService.getById(id);
        // 如果是下架状态，前台查不到
        if (product != null && product.getStatus() == 1) {
            return product;
        }
        return null;
    }
}