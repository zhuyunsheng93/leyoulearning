package com.mybatis.dao;

import com.mybatis.pojo.User;
import java.util.List;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/8/20 12:01
 */
public interface UserDao {
  /**
   * 根据id查询用户信息
   *
   * @param id
   * @return
   */
  public User queryUserById(String id);

  /**
   * 查询所有用户信息
   *
   * @return
   */
  public List<User> queryUserAll();

  /**
   * 新增用户
   *
   * @param user
   */
  public void insertUser(User user);

  /**
   * 更新用户信息
   *
   * @param user
   */
  public void updateUser(User user);

  /**
   * 根据id删除用户信息
   *
   * @param id
   */
  public void deleteUser(String id);

}
