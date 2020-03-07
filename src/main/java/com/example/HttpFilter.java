package com.example;

import com.example.concurrent.threadLocal.RequestHolder;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 调用ThreadLocal，实现Filter接口，主要有三个方法
 * init初始化，destroy退出，主要执行的操作是doFilter
 *
 * @author sunyunlong5
 * @version 1.0
 * @since 2018/12/21 19:32
 */

public class HttpFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void destroy() {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;

    RequestHolder.add(Thread.currentThread().getId());

    filterChain.doFilter(servletRequest,servletResponse);
  }
}
