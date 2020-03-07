package com.example.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestFanXing
 * @Decription
 * @Auther Sunyunlong
 * @Date 2019-09-27 16:25
 * @Version 1.0
 **/
public class TestFanXing {

    public static void main(String[] args) {

        B b = new B("1","1");
        B b1 = new B("2","2");

        List<B> list = new ArrayList<>();
        list.add(b);
        list.add(b1);

//        A<B> a = new A<>();
//        a.setRowList(list);
//
//        List<B> sub = a.sub();
//        System.out.println(sub);

        List<?> sub = A.sub(list);
        System.out.println(sub);
    }
}

class A{

    private String name;

//    private List<T> rowList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<T> getRowList() {
//        return rowList;
//    }
//
//    public void setRowList(List<T> rowList) {
//        this.rowList = rowList;
//    }

    public static List<?> sub(List<?> list){
        return list.subList(0,1);

    }
}

class B{
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

    public B() {
    }

    public B(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}