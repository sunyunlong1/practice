package com.example.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName test
 * @Decription TODO
 * @Auther mac
 * @Date 2019-12-23 15:48
 * @Version 1.0
 **/
public class test {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student stu1 = new Student();
        Student stu2 = new Student();
        list.add(stu1);
        list.add(stu2);
        for (Student student : list) {
            System.out.println(student.getName());
            System.out.println(student.getAge());
        }
        System.out.println("---------------------");
        stu1.setAge("123");
        stu1.setName("10");

        stu2.setName("456");
        stu2.setAge("20");
        for (Student student : list) {
            System.out.println(student.getName());
            System.out.println(student.getAge());
        }
    }
}

class Student {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
