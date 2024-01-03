package com.efufu.mstest.vo;

public class User {
    String name;
    String sex;
    String msg;
    String grade;
    String filename;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", msg='" + msg + '\'' +
                ", grade='" + grade + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public User(String name, String sex, String msg, String grade, String filename) {
        this.name = name;
        this.sex = sex;
        this.msg = msg;
        this.grade = grade;
        this.filename = filename;
    }
}
