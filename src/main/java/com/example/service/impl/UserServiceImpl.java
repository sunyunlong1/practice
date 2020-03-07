package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author sunyunlong5
 * @version 1.0
 * @date 2018/11/20 11:45
 */
@Repository
public class UserServiceImpl implements UserService {
@Autowired
UserDao userDao;

  @Override
  public String userLogin(String name, String password) {
    User user = userDao.login(name);
    if(user!=null) {
      if (password.equals(user.getPassword())) {
        return "success";
      } else {
        return "fail";
      }
    }else{
      return "error";
    }
  }

  @Override
  public List<User> hello(String name, String password) {
    Map<String,String> map = new HashMap<>();
    map.put("name",name);
    map.put("password",password);
    List<User> hello = userDao.hello(map);
    return hello;
  }
}
