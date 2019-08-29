package com.mybatis.dao;

import com.mybatis.pojo.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/8/29 15:51
 */
public interface DynamicSqlMapper {

  List<User> queryUserList(@Param("name") String name);

  List<User> queryUserListByNameOrAge(@Param("name") String name, @Param("age") Integer age);

  List<User> queryUserListByNameAndAge(@Param("name") String name, @Param("age") Integer age);

  void updateUser(User user);

  List<User> queryUserListByIds( List ids);
}
