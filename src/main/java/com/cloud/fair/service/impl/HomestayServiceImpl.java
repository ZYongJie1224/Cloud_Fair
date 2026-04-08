package com.cloud.fair.service.impl;

import com.cloud.fair.entity.Homestay;
import com.cloud.fair.mapper.HomestayMapper;
import com.cloud.fair.service.HomestayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HomestayServiceImpl implements HomestayService {
    @Autowired
    private HomestayMapper homestayMapper;

    @Override
    public boolean add(Homestay homestay) { return homestayMapper.insert(homestay) > 0; }
    @Override
    public boolean delete(Long id) { return homestayMapper.deleteById(id) > 0; }
    @Override
    public boolean update(Homestay homestay) { return homestayMapper.update(homestay) > 0; }
    @Override
    public Homestay getById(Long id) { return homestayMapper.selectById(id); }
    @Override
    public List<Homestay> getAll() { return homestayMapper.selectAll(); }
}