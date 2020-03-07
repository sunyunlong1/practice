package com.example.design;

/**
 * @ClassName Test
 * @Decription TODO
 * @Auther yunlong.sun
 * @Date 2019-08-23 23:34
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        Work work = new Work();
        work.setHour(15);
        work.writeProgram();


        Work2 work2 = new Work2(new Morning());
        work2.setHour(15);
        work2.writeProgram();
    }
}
