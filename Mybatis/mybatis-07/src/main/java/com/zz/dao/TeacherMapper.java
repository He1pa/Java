package com.zz.dao;


import com.zz.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    //获取老师
    //List<Teacher> getTeacher();

    //获取指定老师的所有学生
    Teacher getTeacher(@Param("tid")int id);
    Teacher getTeacher2(@Param("tid")int id);

}
