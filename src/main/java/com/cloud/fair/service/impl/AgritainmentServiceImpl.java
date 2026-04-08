package com.cloud.fair.service.impl;

import com.cloud.fair.entity.Agritainment;
import com.cloud.fair.mapper.AgritainmentMapper;
import com.cloud.fair.service.AgritainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AgritainmentServiceImpl implements AgritainmentService {
    @Autowired
    private AgritainmentMapper agritainmentMapper;

    @Override
    public boolean add(Agritainment agritainment) { return agritainmentMapper.insert(agritainment) > 0; }
    @Override
    public boolean delete(Long id) { return agritainmentMapper.deleteById(id) > 0; }
    @Override
    public boolean update(Agritainment agritainment) { return agritainmentMapper.update(agritainment) > 0; }
    @Override
    public Agritainment getById(Long id) { return agritainmentMapper.selectById(id); }
    @Override
    public List<Agritainment> getAll() { return agritainmentMapper.selectAll(); }
}