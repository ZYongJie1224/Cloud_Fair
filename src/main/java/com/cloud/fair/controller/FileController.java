package com.cloud.fair.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        try {
            // 获取原文件名及后缀
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));

            // 生成新的UUID文件名，防止重名覆盖
            String newFileName = UUID.randomUUID().toString() + extension;

            // 存储路径：项目根目录下的 uploads 文件夹
            String path = System.getProperty("user.dir") + "/uploads/";
            File dest = new File(path + newFileName);

            // 保存文件到本地
            file.transferTo(dest);

            // 返回可供访问的图片URL (配合上面的 WebConfig)
            // 假设前端运行在同一域名下，直接返回相对路径即可；如果跨域，可拼接 http://localhost:8080/uploads/...
            return "/uploads/" + newFileName;

        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败: " + e.getMessage();
        }
    }
}