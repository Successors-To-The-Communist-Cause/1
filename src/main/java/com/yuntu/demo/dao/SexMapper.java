package com.yuntu.demo.dao;



import com.yuntu.demo.pojo.Sex;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SexMapper {
    List<Sex> getAll();
}
