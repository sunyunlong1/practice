package com.example.design;

/**
 * @ClassName Work
 * @Decription 未使用状体模式
 * @Auther yunlong.sun
 * @Date 2019-08-23 23:06
 * @Version 1.0
 **/
public class Work {

    private int hour;

    private boolean finish = false;

    public boolean isFinish() {

        return finish;

    }

    public void setFinish(boolean finish) {

        this.finish = finish;

    }

    public int getHour() {

        return hour;

    }

    public void setHour(int hour) {

        this.hour = hour;

    }

    public void writeProgram() {

        if (hour < 12) {

            System.out.println("当前时间" + hour + "上午工作,精神百倍");

        } else if (hour < 14) {

            System.out.println("当前时间" + hour + "吃饭午休,又饿又困");

        } else if (hour < 19) {

            System.out.println("当前时间" + hour + "下午状态不错");

        } else {

            if (finish) {

                System.out.println("当前时间" + hour + "下班回家");

            } else {

                if (hour < 22) {

                    System.out.println("当前时间" + hour + "还在加班,好累");

                } else {

                    System.out.println("当前时间" + hour + "已猝死");

                }

            }

        }

    }

}
