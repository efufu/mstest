package com.efufu.mstest.dao;

import com.efufu.mstest.vo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICourse {
    @Select("select * from course")
    @Results(id = "courses",value = {
            @Result(column = "id" ,property = "id"),
            @Result(column = "name",property = "name")
    })
    public List<Course> find();

    @Insert("insert into course(id,sid,name) values (#{id},#{sid},#{name})")
    void add(@Param("id") int id,@Param("sid") int sid,@Param("name") String name);

    @Update("UPDATE course SET name = #{name} WHERE id = #{id}")
    void update(Course course);

    @Delete("DELETE FROM course WHERE id = #{id}")
    void delete(int id);
}
