package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.model.User;
import com.example.service.TestAesService;
import com.example.utils.SecurityParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestAesController {

    @Autowired
    TestAesService testAesService;

    /**
     * 测试返回数据，会自动加密
     * @return
     */
    @GetMapping("/get")
    @ResponseBody
    @SecurityParameter
    public Object get() {
        User info = new User();
        info.setName("好看");
        return info;
    }
    /**
     * 自动解密，并将返回信息加密
     * @param info
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    @SecurityParameter
    public Object save(@RequestBody User info) {
        return info;
    }
}
