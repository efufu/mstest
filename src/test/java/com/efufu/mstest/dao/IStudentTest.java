package com.efufu.mstest.dao;

import com.efufu.mstest.service.SessionUtil;
import com.efufu.mstest.vo.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

class IStudentTest {
    SessionUtil sessionUtil = new SessionUtil();

    @Test
    void findById() {
        IStudent iStudent = sessionUtil.getIStudent();
        Student s = iStudent.findById(3);
        System.out.println(s);
        sessionUtil.destroy();
    }

    @Test
    void find() {
        IStudent iStudent = sessionUtil.getIStudent();
        List<Student> students = iStudent.find();
        for (Student s : students) {
            System.out.println(s);
        }
        sessionUtil.destroy();
    }

}