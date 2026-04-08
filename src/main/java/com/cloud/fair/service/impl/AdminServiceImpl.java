package com.cloud.fair.service.impl;

import com.cloud.fair.entity.Admin;
import com.cloud.fair.mapper.AdminMapper;
import com.cloud.fair.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        return adminMapper.login(username, password);
    }
}