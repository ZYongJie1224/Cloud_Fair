package com.cloud.fair.service;

import com.cloud.fair.entity.Admin;

public interface AdminService {
    Admin login(String username, String password);
}