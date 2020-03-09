package list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestArrayList
 * @Decription TODO
 * @Auther mac
 * @Date 2020-03-09 01:09
 * @Version 1.0
 **/
public class TestArrayList {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>(100);
        a.add("1");
        System.out.println(a.size());
        a.set(0,"2");
        System.out.println(a.toString());

        //set前会比较下标是否越界，而比较的size是包含元素的大小
    }
}
