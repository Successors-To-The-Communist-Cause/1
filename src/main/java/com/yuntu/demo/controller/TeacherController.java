package com.yuntu.demo.controller;


import com.yuntu.demo.pojo.Sex;
import com.yuntu.demo.pojo.Teacher;
import com.yuntu.demo.service.SexService;
import com.yuntu.demo.service.TeacherService;
import com.yuntu.demo.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    SexService sexService;

    @RequestMapping("/getSex")
    @ResponseBody
    public List<Sex> getSex(Sex sex, Model model){
        List<Sex> sexList= sexService.getAll();
        model.addAttribute("sex",sex);
        return sexList;
    }



    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }

    /*分页*/
    @RequestMapping("/getPageAll")
    @ResponseBody
    public PageUtil<Teacher> getPageAll(String pageindex, Model model){
        if (pageindex == null || "".equals(pageindex)){
            pageindex = "1";
        }
        if (Integer.parseInt(pageindex)<1){
            pageindex = "1";
        }
        PageUtil<Teacher> pageUtil = new PageUtil<Teacher>();
        pageUtil.setPageindex(Integer.parseInt(pageindex));
        pageUtil.setPagesize(5);
        teacherService.getPageAll(pageUtil);
        model.addAttribute("pageUtil",pageUtil);
        return pageUtil;
    }

    /*添加*/

    @RequestMapping("/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/addtea")
    public String add(String t_name, String t_idcard, Date t_birthday, String t_loginName, String t_pwd, int t_sex){
        Teacher teacher=new Teacher(t_name,t_idcard,new Date(),t_loginName,t_pwd,t_sex);
        teacherService.addPro(teacher);
        return "index";
    }

    /*删除*/
    @RequestMapping("/del/{t_id}")
    @ResponseBody
    public boolean del(@PathVariable int t_id){
        return teacherService.delPro(t_id);
    }

    /*查单个
     * 修改
     * */
    @RequestMapping("/upd.html")
    public String upd(Model model,int t_id){
        Teacher teacher=teacherService.selPro(t_id);
        model.addAttribute("teacher",teacher);
        model.addAttribute("t_id",t_id);
        return "upd";
    }

    @RequestMapping("/selPro")
    @ResponseBody
    public Teacher sel(int t_id,Model model){
        Teacher teacher=null;
        teacher=teacherService.selPro(t_id);
        model.addAttribute("teacher",teacher);
        return teacher;
    }

    @RequestMapping("upd")
    public String upd(int t_id,String t_name, String t_idcard, Date t_birthday, String t_loginName, String t_pwd, int t_sex){
        Teacher teacher=new Teacher(t_id,t_name,t_idcard,new Date(),t_loginName,t_pwd,t_sex);
        teacherService.updPro(teacher);
        return "index";
    }
}
