package com.mybatis.dao;

import com.mybatis.dao.UserMapper;
import com.mybatis.pojo.User;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/8/21 9:41
 */
public class UserMapperTest {

private UserMapper userMapper;

  @Before
  public void setUp() throws Exception {
    String resource = "config/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);//这个true代表的是默认开启事务自动提交。
    // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
    // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
    // 3. Statement的resultType必须和mapper接口方法的返回类型一致
    // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）

    this.userMapper = sqlSession.getMapper(UserMapper.class);
  }

  @Test
  public void login() {
    System.out.println(this.userMapper.login("hj","123456"));
  }

  @Test
  public void queryUserByTableName() {
    List<User> userList = this.userMapper.queryUserByTableName("tb_user");
    System.out.println(userList);
  }

  @Test
  public void queryUserById() {
    System.out.println(this.userMapper.queryUserById("1"));
  }

  @Test
  public void queryUserAll() {
    System.out.println(this.userMapper.queryUserAll());
  }

  @Test
  public void insertUser() {
    User user = new User();
    user.setId("6666");
    user.setBirthday(new Date("1990/12/01"));
    user.setName("hh");
    user.setUserName("zhuyunsheng");
    this.userMapper.insertUser(user);
  }

  @Test
  public void updateUser() {
    User user  =new User();
    user.setId("6666");
    this.userMapper.insertUser(user);
  }

  @Test
  public void deleteUserById() {
    this.userMapper.deleteUserById("1");
  }
}