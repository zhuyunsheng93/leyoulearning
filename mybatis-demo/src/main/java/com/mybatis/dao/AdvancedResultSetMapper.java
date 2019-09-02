package com.mybatis.dao;

import com.mybatis.pojo.Order;
import com.mybatis.pojo.OrderUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/8/30 10:46
 */
public interface AdvancedResultSetMapper {

  /**
   *
   * @param number
   * @return
   */
  OrderUser queryOrderUserByOrderNumber(@Param("number") String number);

  Order queryOrderWithUserByOrderNumber(@Param("number") String number);

  Order queryOrderWithUserAndDetailByOrderNumber(@Param("number") String number);
}
