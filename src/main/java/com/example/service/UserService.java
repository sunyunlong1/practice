package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author sunyunlong5
 * @version 1.0
 * @date 2018/11/20 11:44
 */
@Service
public interface UserService {

  String userLogin(String name, String password);

  List<User> hello(String name,String password);
}
