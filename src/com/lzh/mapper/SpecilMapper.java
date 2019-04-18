package com.lzh.mapper;

import com.lzh.po.Specil;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SpecilMapper {

    // 分页查询
    List<Specil> findSpecilSplit(Map<String,Object> map);

    List<Specil> findSpecilByParam(@Param(value="start")int start,@Param(value="pageSize")int pageSize);
}
