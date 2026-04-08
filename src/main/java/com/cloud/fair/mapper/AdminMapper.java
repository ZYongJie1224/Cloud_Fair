package com.cloud.fair.mapper;

import com.cloud.fair.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    // 根据账号和密码查询管理员
    Admin login(@Param("username") String username, @Param("password") String password);
}