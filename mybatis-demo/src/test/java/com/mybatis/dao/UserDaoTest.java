package com.batis.dao;

import static org.junit.Assert.*;

import com.mybatis.dao.UserDao;
import com.mybatis.dao.impl.UserDaoImpl;
import com.mybatis.pojo.User;
import java.io.InputStream;
import java.util.Date;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/8/20 14:16
 */
public class UserDaoTest {

  private SqlSession sqlSession;
  public UserDao userDao;

  @Before
  public void setUp() throws Exception {
    String resource = "config/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    this.sqlSession = sqlSession;
    this.userDao = new UserDaoImpl(sqlSession);
  }

  @Test
  public void queryUserById() {
    System.out.println(this.userDao.queryUserById("1"));
  }

  @Test
  public void queryUserAll() {
    System.out.println(this.userDao.queryUserAll());
  }

  @Test
  public void insertUser() {
    User user = new User();

    user.setAge(16);
    user.setBirthday(new Date("1990/09/02"));
    user.setName("大鹏");
    user.setPassword("123456");
    user.setSex(1);
    user.setUserName("evan");
    this.userDao.insertUser(user);
    this.sqlSession.commit();
  }

  @Test
  public void updateUser() {
    User user = new User();
    user.setBirthday(new Date());
    user.setName("静鹏");
    user.setPassword("654321");
    user.setSex(1);
    user.setUserName("evanjin");
    user.setId("1");
    this.userDao.updateUser(user);
    this.sqlSession.commit();
  }

  @Test
  public void deleteUser() {
    this.userDao.deleteUser("1");
  }
}