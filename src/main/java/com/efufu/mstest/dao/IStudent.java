package com.efufu.mstest.dao;

import com.efufu.mstest.vo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IStudent {
    @Select("select s.id sid, s.name sname, c.id cid, c.name cname from student s left join course c on s.id=c.sid where s.id=#{id}")
    @Results(value = {
            @Result(column = "sid",property = "id",id = true),
            @Result(column = "sname",property = "name"),
            @Result(column = "courses",property = "courses",many = @Many(resultMap = "com.efufu.mstest.dao.ICourse.courses",columnPrefix = "c"))
    })
    public Student findById(int id);

    // column:查询的数据库表的字段，property:类的属性
    @Select("select s.id sid, s.name sname, c.id cid, c.name cname from student s left join course c on s.id=c.sid")
    @Results(value = {
            @Result(column = "sid",property = "id",id = true),
            @Result(column = "sname",property = "name"),
            @Result(column = "courses",property = "courses",many = @Many(resultMap = "com.efufu.mstest.dao.ICourse.courses",columnPrefix = "c"))
    })
    public List<Student> find();


}
