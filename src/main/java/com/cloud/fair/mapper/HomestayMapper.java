package com.cloud.fair.mapper;

import com.cloud.fair.entity.Homestay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface HomestayMapper {
    int insert(Homestay homestay);
    int deleteById(Long id);
    int update(Homestay homestay);
    Homestay selectById(Long id);
    List<Homestay> selectAll();
    Long selectIdByCustomCode(@Param("customCode") String customCode);
    Long selectIdByCustomCodeExcludeId(@Param("customCode") String customCode, @Param("id") Long id);
}
