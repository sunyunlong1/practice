package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.data.ApiResponse;
import com.example.model.Result;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author sunyunlong5
 * @version 1.0
 * @date 2018/11/20 11:48
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "index";
    }

    @RequestMapping("/exit")
    public String exit() {
        return "exit";
    }

    @RequestMapping("/success")
    @ResponseBody
    public String success() {
        return "success";
    }

    @RequestMapping("/checkLogin")
    @ResponseBody
    //public String checkLogin(@RequestBody User user , HttpServletRequest request) {
    public String checkLogin(HttpServletRequest request) {
//    HttpSession session = request.getSession();
//    session.setAttribute("login_ticket",user.getName()+user.getPassword());
//    session.setMaxInactiveInterval(60*60*24);
//    if(user.getName().equals("tom")&& user.getPassword().equals("123")){
//      return JSON.toJSONString("success");
//    }else{
//      return  JSON.toJSONString("error");
//    }


        Map<String, String> stringCookieMap = ReadCookieMap(request);
        String value = stringCookieMap.get("login_ticket");
        //System.out.println(value);
        HttpSession session = request.getSession();
        String result = (String) session.getAttribute(value);

        if (result != null) {
            return result;
        }else{
           return JSON.toJSONString(new Result(205,"登陆状态已失效","-"));
            //return "code:205,message:登陆状态已失效";
        }

//    HttpSession session = request.getSession();
//
//
//    session.setAttribute("login_ticket",name+password);
//
//    session.getAttribute("login_ticket");
//
//    session.setMaxInactiveInterval(60*60*24);
//    if(name.equals("tom")&& password.equals("123")){
//      return JSON.toJSONString("success");
//    }else{
//      return  JSON.toJSONString("error");
//    }
    }

    //  @RequestMapping("/checkLogin")
//  public String checkLogin(HttpSession session){
//    String token =(String)session.getAttribute("token");
//    if(token!=null){
//      return "有全局会话";
//    }else{
//      return "没有全局会话";
//    }
//  }
//
    @RequestMapping("/Login")
    @ResponseBody
    public String Login(@RequestBody User user,
                        HttpServletRequest request) {
        Map<String, String> readCookieMap = ReadCookieMap(request);
        String login_ticket = readCookieMap.get("login_ticket");
        HttpSession session = request.getSession();
        session.setAttribute(login_ticket, user.toString());
        return JSON.toJSONString(new Result(200,"-",userService.userLogin(user.getName(), user.getPassword())));
    }

    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private static Map<String, String> ReadCookieMap(HttpServletRequest request) {
        Map<String, String> cookieMap = new HashMap<String, String>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie.getValue());
            }
        }
        return cookieMap;
    }

    @RequestMapping("/test")
    @ResponseBody
    public ApiResponse test(String name, String password) {
        String s = userService.userLogin(name, password);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode("1");
        apiResponse.setIsSuccess("success");
        apiResponse.setData(s);
        apiResponse.setMsg("测试接受数据!");
        return apiResponse;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public ApiResponse<String> hello(@RequestBody User user){
        List<User> hello = userService.hello(user.getName(), user.getPassword());
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode("200");
        apiResponse.setIsSuccess("issuccess");
        apiResponse.setMsg("-");
        JSON.toJSON(hello);
        apiResponse.setData(JSON.toJSON(hello));
        return apiResponse;
    }
}
