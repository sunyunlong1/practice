package com.example.practice;

import org.junit.Test;
import proxy.dynamicProxy.aop.CustomAspect;
import proxy.dynamicProxy.aop.IUserService;
import proxy.dynamicProxy.aop.JDKDynamicProxyGenerator;
import proxy.dynamicProxy.aop.UserServiceImpl;

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
public class TestAopJDKProxy {
    @Test
    public void testJDKProxy() throws Exception {
        System.out.println("无代理前 调用方法 userService.saveUser 输出......");
        IUserService userService = new UserServiceImpl();
        userService.saveUser("zby", "1234567890");
        System.out.println("有代理后AOP 是怎么样的？ Proxy......");
        IUserService proxyUserService = (IUserService) JDKDynamicProxyGenerator.generatorJDKProxy(userService, new CustomAspect());
        proxyUserService.saveUser("zby", "1234567890");        /** 制造异常,两个入参都是null   */
        proxyUserService.saveUser(null, null);
    }
}