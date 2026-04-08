package com.cloud.fair.mapper;

import com.cloud.fair.entity.Homestay;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface HomestayMapper {
    int insert(Homestay homestay);
    int deleteById(Long id);
    int update(Homestay homestay);
    Homestay selectById(Long id);
    List<Homestay> selectAll();
}