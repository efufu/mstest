package com.efufu.mstest.controller;

import com.efufu.mstest.vo.User;
import com.google.gson.Gson;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @RequestMapping(value = "find", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String find() {

        return new Gson().toJson(null);
    }

    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String add(String name, String sex, String msg, String grade, MultipartFile file) {


        User user = new User(name, sex, msg, grade, file.getOriginalFilename(),"adb");
        System.out.println(name);
        System.out.println(sex);
        System.out.println(msg);
        System.out.println(grade);
        System.out.println(file.getOriginalFilename());

        System.out.println(user);
        return new Gson().toJson(user);
    }

    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String update(@Param("id") int id, @RequestBody String json) {
        // 解析 JSON 数据并更新学生

        return "更新成功";
    }
}
