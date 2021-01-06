package com.yuntu.demo.dao;



import com.yuntu.demo.pojo.Teacher;
import com.yuntu.demo.util.PageUtil;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    //分页
    int getCount();
    List<Teacher> getPageAll(PageUtil<Teacher> pageUtil);

    //添加
    int addPro(Teacher teacher);

    //删除
    int delPro(int id);

    //查单个
    Teacher selPro(int id);

    //修改
    int updPro(Teacher teacher);
}
