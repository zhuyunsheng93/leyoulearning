package com.mybatis.dao;



import com.mybatis.pojo.Order;
import com.mybatis.pojo.OrderUser;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
/**
 * @Author: zhuyunsheng
 * @Date: 2019/8/30 11:03
 */
public class AdvancedResultSetMapperTest {

  private AdvancedResultSetMapper advancedResultSetMapper;


  @Before
  public void setUp() throws Exception {
    String resource = "config/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    this.advancedResultSetMapper = sqlSession.getMapper(AdvancedResultSetMapper.class);
  }
  @Test
  public void queryOrderUserByOrderNumber() throws Exception {
    OrderUser orderUser = advancedResultSetMapper.queryOrderUserByOrderNumber("20190830");
    System.out.println(orderUser);
  }
  @Test

  public void queryOrderWithUserByOrderNumber() throws Exception {
    Order order = advancedResultSetMapper.queryOrderWithUserByOrderNumber("20190830");
    System.out.println(order);
  }
}