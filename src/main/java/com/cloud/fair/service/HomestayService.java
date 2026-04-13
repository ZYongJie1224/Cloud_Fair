package com.cloud.fair.service;

import com.cloud.fair.entity.Homestay;
import java.util.List;

public interface HomestayService {
    boolean add(Homestay homestay);
    boolean delete(Long id);
    boolean update(Homestay homestay);
    Homestay getById(Long id);
    List<Homestay> getAll();
    boolean existsByCustomCode(String customCode);
    boolean existsByCustomCodeExcludeId(String customCode, Long id);
}
