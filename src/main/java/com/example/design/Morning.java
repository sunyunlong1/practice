package com.example.design;

/**
 * @ClassName Morning
 * @Decription TODO
 * @Auther yunlong.sun
 * @Date 2019-08-23 23:12
 * @Version 1.0
 **/
public class Morning extends State{

    @Override
    public void writeProgram(Work2 w) {

        if(w.getHour()<12) {

            System.out.println("当前时间"+w.getHour()+"上午工作,精神百倍");

        }else {

           //超过12点,则进入中午工作状态

            w.setState(new Noon());

            w.writeProgram();

        }

    }

}
