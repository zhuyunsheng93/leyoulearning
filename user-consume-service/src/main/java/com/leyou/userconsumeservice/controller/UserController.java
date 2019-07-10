package com.leyou.userconsumeservice.controller;

import com.leyou.userconsumeservice.pojo.User;
import com.leyou.userconsumeservice.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/7/10 16:14
 */
@Controller
@RequestMapping("consume")
public class UserController {
  @Autowired
  private UserService userService;
  @GetMapping
  @ResponseBody
  public List<User> queryUsersByIds(@RequestParam("ids") List<Long> ids) {
    System.out.println("进入到方法中");
    return this.userService.queryUserByIds(ids);
  }
}
