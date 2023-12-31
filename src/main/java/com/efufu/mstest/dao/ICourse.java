package com.efufu.mstest.dao;

import com.efufu.mstest.vo.Course;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ICourse {
    @Select("select * from course")
    @Results(id = "courses",value = {
            @Result(column = "id" ,property = "id",id = true),
            @Result(column = "name",property = "name")
    })
    public List<Course> find();
}
