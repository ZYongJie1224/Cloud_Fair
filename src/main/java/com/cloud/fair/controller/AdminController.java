package com.cloud.fair.controller;

import com.cloud.fair.entity.Admin;
import com.cloud.fair.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin admin) {
        // 调用 Service 查询数据库验证账号密码
        Admin loginAdmin = adminService.login(admin.getUsername(), admin.getPassword());

        if (loginAdmin != null) {
            // 登录成功：返回一个 Token 和 用户信息给前端
            Map<String, Object> result = new HashMap<>();
            // 真实项目中这里会生成 JWT Token，这里用简单的拼接模拟
            result.put("token", "token_admin_" + loginAdmin.getId());
            result.put("username", loginAdmin.getUsername());

            return ResponseEntity.ok(result);
        } else {
            // 登录失败：返回 401 Unauthorized 状态码
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("账号或密码错误");
        }
    }
}