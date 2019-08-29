package com.mybatis.dao;

import static org.junit.Assert.*;

import com.mybatis.pojo.User;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.soap.SOAPBinding.Use;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/8/29 15:52
 */
public class DynamicSqlMapperTest {

  private DynamicSqlMapper dynamicSqlMapper;

  @Before
  public void setUp() throws Exception {
    String resource = "config/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    this.dynamicSqlMapper = sqlSession.getMapper(DynamicSqlMapper.class);
  }
  /**
   * 检测动态语句的if标签
   * */
  @Test
  public void queryUserList(){
    List<User> users = this.dynamicSqlMapper.queryUserList("");
    this.dynamicSqlMapper.queryUserList("");
    for(User user:users){
      System.out.println(user);
    }
  }
  @Test
  public  void queryUserListByNameOrAge(){
    List<User> users = this.dynamicSqlMapper.queryUserListByNameOrAge(null,null);
   for(User user:users){
     System.out.println(user);
   }
  }
  @Test
  public void   queryUserListByNameAndAge(){
    List<User> users = this.dynamicSqlMapper.queryUserListByNameAndAge("h",null);
    for(User user:users){
      System.out.println(user);
    }
  }
  @Test
  public void  updaeUser(){
    User user = new User();
    user.setId("2");
    user.setUserName("zhuyusheng");
    user.setName("朱运升");
    user.setBirthday(new Date());
    user.setAge(26);
    user.setPassword("123456");
    user.setSex(1);
    this.dynamicSqlMapper.updateUser(user);
  }
  @Test
  public void queryUserListByIds(){
    List list = new ArrayList();
    list.add("1");
    list.add("2");
    List<User> users = this.dynamicSqlMapper.queryUserListByIds(list);
    for(User user:users){
      System.out.println(user);
    }
  }
}