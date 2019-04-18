package com.lzh.test;

import com.lzh.mapper.SpecilMapper;
import com.lzh.po.Specil;
import com.lzh.util.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestsSpecil {

    @Test
    public void findAllByColumnLike(){

        SqlSession sqlSession = MybatisUtils.getSqlSession(false);
        String columnName = "spilinfoname";
        String keyword = "技";
        String columnName2 = "spilinfoid";
        String rank = "DESC";
        int pageNum = 1;
        int pageSize = 5;
        int start = (pageNum-1)*pageSize;
        SpecilMapper specilMapper = sqlSession.getMapper(SpecilMapper.class);

        Map<String,Object> map = new HashMap<>();
        map.put("columnName",columnName);
        map.put("keyword",keyword);
        map.put("rank",rank);
        map.put("columnName2",columnName2);
        map.put("start",start);
        map.put("pageSize",pageSize);

        List<Specil> specilList = specilMapper.findSpecilSplit(map);

        for (Specil specil : specilList) {
            System.out.println(specil);
        }

        // 5、关闭SqlSession
        MybatisUtils.closeSqlSession(sqlSession);
    }


}
