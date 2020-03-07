package com.example.design;

/**
 * @ClassName Work2
 * @Decription TODO
 * @Auther yunlong.sun
 * @Date 2019-08-23 23:13
 * @Version 1.0
 **/
public class Work2 {

    private State state;

    //通过构造器,定义工作的初始状态

    public Work2(State state) {

        this.state = state;

    }

    private int hour;

    private boolean finish = false;

    //用于读取当前状态或者设置新状态

    public State getState() {

        return state;

    }

    public void setState(State state) {

        this.state = state;

    }

    public int getHour() {

        return hour;

    }

    public void setHour(int hour) {

        this.hour = hour;

    }

    public boolean isFinish() {

        return finish;

    }

    public void setFinish(boolean finish) {

        this.finish = finish;

    }

    public void writeProgram() {

        //其子类对请求做处理,并设置一下状态

        state.writeProgram(this);

    }

}
