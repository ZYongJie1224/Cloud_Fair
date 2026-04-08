package com.cloud.fair.service;

import com.cloud.fair.entity.Agritainment;
import java.util.List;

public interface AgritainmentService {
    boolean add(Agritainment agritainment);
    boolean delete(Long id);
    boolean update(Agritainment agritainment);
    Agritainment getById(Long id);
    List<Agritainment> getAll();
}