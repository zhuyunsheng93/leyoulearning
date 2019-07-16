package com.leyou.userservicedemo.service;

import com.leyou.userservicedemo.mapper.UserMapper;
import com.leyou.userservicedemo.pojo.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/7/10 14:15
 */
@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public User queryById(Long id)throws InterruptedException {
    Thread.sleep(new Random().nextInt(2000));
    return this.userMapper.selectByPrimaryKey(id);
  }

  @Transactional
  public void deleteById(Long id) {
    this.userMapper.deleteByPrimaryKey(id);
  }

  public List<User> queryAll() {
    return this.userMapper.selectAll();
  }

  public List<User> queryByIds(List<Long> ids) {
    List<User> userList = new ArrayList<>();
    for (Long id : ids) {
      userList.add(this.userMapper.selectByPrimaryKey(id));
    }
    return userList;
  }
}
