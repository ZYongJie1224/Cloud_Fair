package com.cloud.fair.mapper;


import com.cloud.fair.entity.Agritainment;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AgritainmentMapper {
    int insert(Agritainment agritainment);
    int deleteById(Long id);
    int update(Agritainment agritainment);
    Agritainment selectById(Long id);
    List<Agritainment> selectAll();
}