package com.example.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标记推荐的类或者写法:
 *
 * @author sunyunlong5
 * @version 1.0
 * @date 2018/12/18 23:06
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Recommend {

  String value() default "";
}
