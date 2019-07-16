package com.leyou.userservicedemo.controller;

import com.leyou.userservicedemo.pojo.User;
import com.leyou.userservicedemo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/7/10 14:16
 */
@Controller
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  @ResponseBody
  public User queryUserById(@PathVariable("id") Long id) throws InterruptedException {
    return this.userService.queryById(id);
  }

  @GetMapping
  public List<User> queryUsersByIds(@RequestParam("ids") List<Long> ids) {

    return this.userService.queryByIds(ids);

  }
}
