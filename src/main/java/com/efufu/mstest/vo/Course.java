package com.efufu.mstest.vo;

import java.util.List;

public class Course {
    int id;
    String name;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
