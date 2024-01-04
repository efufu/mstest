package com.efufu.mstest.vo;

public class User {
    String name;
    String sex;
    String msg;
    String grade;
    String filename;
    String filepath;

    public User() {
    }


    public User(String name, String sex, String msg, String grade, String filename, String filepath) {
        this.name = name;
        this.sex = sex;
        this.msg = msg;
        this.grade = grade;
        this.filename = filename;
        this.filepath = filepath;
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

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", msg='" + msg + '\'' +
                ", grade='" + grade + '\'' +
                ", filename='" + filename + '\'' +
                ", filepath='" + filepath + '\'' +
                '}';
    }
}
