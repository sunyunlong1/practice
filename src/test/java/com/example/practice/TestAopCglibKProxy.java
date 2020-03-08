package com.example.practice;

import org.junit.Test;
import proxy.dynamicProxy.aop.cglib.CglibProxyGenerator;
import proxy.dynamicProxy.aop.cglib.CustomAspect;
import proxy.dynamicProxy.aop.cglib.UserServiceImpl;

/**
 * @Package: org.vincent <br/>
 * @Description： 基于动态代理类AOP测试案例 <br/>
 * @author: lenovo <br/>
 * @Company: PLCC <br/>
 * @Copyright: Copyright (c) 2019 <br/>
 * @Version: 1.0 <br/>
 * @Modified By: <br/>
 * @Created by lenovo on 2018/12/26-16:56 <br/>
 */
public class TestAopCglibKProxy {
    @Test
    public void testCglibProxy() {
        System.out.println("before Proxy......");
        UserServiceImpl userService = new UserServiceImpl();
        userService.saveUser("zby", "1234567890");
        System.out.println("引入Cglib  Proxy代理库 后......");
        UserServiceImpl proxyUserService = (UserServiceImpl) CglibProxyGenerator.generatorCglibProxy(userService, new CustomAspect());
        proxyUserService.saveUser("zby", "1234567890");
    }
}