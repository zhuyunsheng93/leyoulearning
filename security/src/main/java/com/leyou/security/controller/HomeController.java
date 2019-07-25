package com.leyou.security.controller;

import com.leyou.security.entity.Msg;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/7/15 10:49
 */
@Controller
public class HomeController {

  @RequestMapping("/")
  public String index(Model model) {
    Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
    model.addAttribute("msg", msg);
    return "index";
  }

  @PreAuthorize("hasAuthority('ROLE_USER')")
  @RequestMapping(value = "/admin/test1")
  @ResponseBody
  public String adminTest() {
    return "ROLE_USER";
  }
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @RequestMapping(value="/admin/test2")
  @ResponseBody
  public String adminTest2(){
    return "ROLE_ADMIN";
  }
}
