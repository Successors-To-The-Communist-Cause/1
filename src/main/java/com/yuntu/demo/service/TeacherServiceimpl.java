package com.yuntu.demo.service;


import com.yuntu.demo.dao.TeacherMapper;
import com.yuntu.demo.pojo.Teacher;
import com.yuntu.demo.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("teacherService")
public class TeacherServiceimpl implements  TeacherService {

    @Autowired
    TeacherMapper mapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void getPageAll(PageUtil<Teacher> pageUtil) {
        int count=mapper.getCount();
        if (count>0){
            pageUtil.setCounts(count);
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setList(mapper.getPageAll(pageUtil));
        }else {
            pageUtil.setList(new ArrayList<Teacher>());
        }
    }

    @Override
    public boolean addPro(Teacher teacher) {
        if (mapper.addPro(teacher)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delPro(int id) {
        if (mapper.delPro(id)>0){
            return true;
        }
        return false;
    }

    @Override
    public Teacher selPro(int id) {
        return mapper.selPro(id);
    }

    @Override
    public boolean updPro(Teacher teacher) {
        if (mapper.updPro(teacher)>0){
            return true;
        }
        return false;
    }
}
