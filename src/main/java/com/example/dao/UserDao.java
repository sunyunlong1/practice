package com.example.dao;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author sunyunlong5
 * @version 1.0
 * @date 2018/11/20 11:35
 */
@Mapper
public interface UserDao {

  User login(String name);

  List<User> hello(Map<String,String> map);
}
