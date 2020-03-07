//package com.example;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.alibaba.fastjson.JSON;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.PrintWriter;
//
///**
// * Description:
// *
// * @author sunyunlong5
// * @version 1.0
// * @date 2018/11/22 17:35
// */
//@Component
//public class URLInterceptor implements HandlerInterceptor {
//
//  @Override
//  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//      throws Exception {
//    String requestURI = request.getRequestURI();
////    if (requestURI.contains("checkLogin")){
////      return true;
////    }
//    HttpSession session = request.getSession();
//    String sesssionId = session.getId();
//    String userInfo = (String)session.getAttribute("login_ticket");
//    String result = JSON.toJSONString(userInfo);
//    if(userInfo != null){
//      response.setCharacterEncoding("utf-8");
//      response.setContentType("application/json;charset=utf=8");
//      PrintWriter writer = response.getWriter();
//      writer.write(result);
//      return true;
//    }else{
//      response.setCharacterEncoding("utf-8");
//      response.setContentType("application/json;charset=utf=8");
//      PrintWriter writer = response.getWriter();
//      writer.write("205");
//      return false;
//    }
//  }
//
//  @Override
//  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//      ModelAndView modelAndView) throws Exception {
//
//  }
//
//  @Override
//  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
//      Object handler, Exception ex) throws Exception {
//
//  }
//}
