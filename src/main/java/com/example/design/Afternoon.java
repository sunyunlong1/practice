package com.example.design;

/**
 * @ClassName Afternoon
 * @Decription TODO
 * @Auther mac
 * @Date 2019-08-23 23:26
 * @Version 1.0
 **/
public class Afternoon extends State {

    @Override
    public void writeProgram(Work2 w) {
        if (w.getHour() < 19) {

            System.out.println("当前时间" + w.getHour() + "下午状态不错");

        } else {
            //晚上工作
            System.out.println("晚上加班---");

        }
    }
}
