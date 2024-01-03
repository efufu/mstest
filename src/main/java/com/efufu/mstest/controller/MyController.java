package com.efufu.mstest.controller;

import com.efufu.mstest.dao.ICourse;
import com.efufu.mstest.dao.IStudent;
import com.efufu.mstest.service.SessionUtil;
import com.efufu.mstest.vo.Course;
import com.efufu.mstest.vo.Student;
import com.google.gson.Gson;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MyController {

    @RequestMapping(value = "find", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String find() {
        SessionUtil sessionUtil = new SessionUtil();
        IStudent iStudent = sessionUtil.getIStudent();
        List<Student> students = iStudent.find();
        sessionUtil.destroy();
        return new Gson().toJson(students);
    }

    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addStudent(@RequestBody String json) {
        // 解析 JSON 数据并添加学生
        Student student = new Gson().fromJson(json, Student.class);
        SessionUtil sessionUtil = new SessionUtil();
        IStudent iStudent = sessionUtil.getIStudent();
        ICourse iCourse = sessionUtil.getICourse();
        iStudent.add(student);
        List<Course> courses = student.getCourses();
        for (Course course : courses) {
            iCourse.add(course.getId(), student.getId(),course.getName());
        }

        sessionUtil.destroy();
        return "添加成功";
    }

    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateStudent(@Param("id") int id, @RequestBody String json) {
        // 解析 JSON 数据并更新学生
        Student student = new Gson().fromJson(json, Student.class);
        SessionUtil sessionUtil = new SessionUtil();
        IStudent iStudent = sessionUtil.getIStudent();
        ICourse iCourse= sessionUtil.getICourse();
        iStudent.update(student,id);
        List<Course> courses = student.getCourses();
        for (Course course : courses) {
            iCourse.update(course, student.getId());
        }
        sessionUtil.destroy();
        return "更新成功";
    }

    @RequestMapping(value = "delete", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteStudent(@RequestBody String json) {
        // 解析 JSON 数据并删除学生
        Student student = new Gson().fromJson(json, Student.class);
        SessionUtil sessionUtil = new SessionUtil();
        IStudent iStudent = sessionUtil.getIStudent();
        iStudent.delete(student.getId());
        sessionUtil.destroy();
        return "删除成功";
    }

    @RequestMapping(value = "findById", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findStudentById(@RequestParam int id) {
        SessionUtil sessionUtil = new SessionUtil();
        IStudent iStudent = sessionUtil.getIStudent();
        Student student = iStudent.findById(id);
        sessionUtil.destroy();
        return new Gson().toJson(student);
    }
}
