package com.example.design;

/**
 * @ClassName NoonState
 * @Decription TODO
 * @Auther yunlong.sun
 * @Date 2019-08-23 23:12
 * @Version 1.0
 **/
public class Noon extends State {

    @Override
    public void writeProgram(Work2 w) {

        if(w.getHour()<14) {

            System.out.println("当前时间"+w.getHour()+"吃饭午休,又饿又困");

        }else{
            //超过14点下午继续工作
            w.setState(new Afternoon());

            w.writeProgram();
        }

    }

}
