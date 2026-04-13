package com.cloud.fair.controller;

import com.cloud.fair.entity.Homestay;
import com.cloud.fair.service.HomestayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/homestay")
public class HomestayController {
    @Autowired
    private HomestayService homestayService;

    @GetMapping("/list")
    public List<Homestay> getAll() { return homestayService.getAll(); }
    @GetMapping("/{id}")
    public Homestay getById(@PathVariable Long id) { return homestayService.getById(id); }
    @PostMapping("/add")
    public String add(@RequestBody Homestay homestay) {
        if (StringUtils.hasText(homestay.getCustomCode()) && homestayService.existsByCustomCode(homestay.getCustomCode())) {
            return "编号已存在，添加失败";
        }
        return homestayService.add(homestay) ? "添加成功" : "添加失败";
    }
    @PutMapping("/update")
    public String update(@RequestBody Homestay homestay) {
        if (StringUtils.hasText(homestay.getCustomCode())
                && homestayService.existsByCustomCodeExcludeId(homestay.getCustomCode(), homestay.getId())) {
            return "编号已存在，更新失败";
        }
        return homestayService.update(homestay) ? "更新成功" : "更新失败";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) { return homestayService.delete(id) ? "删除成功" : "删除失败"; }
    @GetMapping("/front/list")
    public List<Homestay> getFrontList() {
        // 过滤出 status == 1 的民宿返回给前端
        return homestayService.getAll().stream()
                .filter(h -> h.getStatus() != null && h.getStatus() == 1)
                .collect(Collectors.toList());
    }

    @GetMapping("/front/detail/{id}")
    public Homestay getFrontDetail(@PathVariable Long id) {
        Homestay homestay = homestayService.getById(id);
        // 如果是下架状态，前台查不到
        if (homestay != null && homestay.getStatus() == 1) {
            return homestay;
        }
        return null;
    }
}
