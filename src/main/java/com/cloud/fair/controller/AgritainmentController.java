package com.cloud.fair.controller;

import com.cloud.fair.entity.Agritainment;
import com.cloud.fair.service.AgritainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/agritainment")
public class AgritainmentController {
    @Autowired
    private AgritainmentService agritainmentService;

    @GetMapping("/list")
    public List<Agritainment> getAll() { return agritainmentService.getAll(); }
    @GetMapping("/{id}")
    public Agritainment getById(@PathVariable Long id) { return agritainmentService.getById(id); }
    @PostMapping("/add")
    public String add(@RequestBody Agritainment agritainment) { return agritainmentService.add(agritainment) ? "添加成功" : "添加失败"; }
    @PutMapping("/update")
    public String update(@RequestBody Agritainment agritainment) { return agritainmentService.update(agritainment) ? "更新成功" : "更新失败"; }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) { return agritainmentService.delete(id) ? "删除成功" : "删除失败"; }
    @GetMapping("/front/list")
    public List<Agritainment> getFrontList() {
        // 过滤出 status == 1 的农家乐返回给前端
        return agritainmentService.getAll().stream()
                .filter(h -> h.getStatus() != null && h.getStatus() == 1)
                .collect(Collectors.toList());
    }

    @GetMapping("/front/detail/{id}")
    public Agritainment getFrontDetail(@PathVariable Long id) {
        Agritainment agritainment = agritainmentService.getById(id);
        // 如果是下架状态，前台查不到
        if (agritainment != null && agritainment.getStatus() == 1) {
            return agritainment;
        }
        return null;
    }

}