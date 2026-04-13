package com.cloud.fair.mapper;


import com.cloud.fair.entity.Agritainment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface AgritainmentMapper {
    int insert(Agritainment agritainment);
    int deleteById(Long id);
    int update(Agritainment agritainment);
    Agritainment selectById(Long id);
    List<Agritainment> selectAll();
    Long selectIdByCustomCode(@Param("customCode") String customCode);
    Long selectIdByCustomCodeExcludeId(@Param("customCode") String customCode, @Param("id") Long id);
}
