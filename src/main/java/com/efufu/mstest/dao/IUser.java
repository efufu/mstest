package com.efufu.mstest.dao;

import com.efufu.mstest.vo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUser {
    @Select("select * from user")
    public List<User> find();

    @Select("select * from user where name=#{name}")
    public User findName(@Param("name")String name);

    @Insert("insert into user values (#{name},#{sex},#{msg},#{grade},#{filename},#{filepath})")
    public void add(User user);

    @Update("update user set sex=#{sex},msg=#{msg},grade=#{grade},filename=#{filename},filepath=#{filepath} where name=#{name}")
    public void update(User user);
}
