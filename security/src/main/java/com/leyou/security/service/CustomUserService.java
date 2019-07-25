package com.leyou.security.service;

import com.leyou.security.dao.SysUserRepository;
import com.leyou.security.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/7/15 10:39
 */
public class CustomUserService implements UserDetailsService {

  @Autowired
  SysUserRepository sysUserRepository;
  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    SysUser user = sysUserRepository.findByUsername(s);
    if(user==null){
      throw  new UsernameNotFoundException("用户名不存在在");
    }
    System.out.println("s:"+s);
    System.out.println("username:"+user.getUsername()+"; password:"+user.getPassword());
    System.out.println("size:"+user.getRoles().size());
    System.out.println("role:"+user.getRoles().get(0).getName());
    return user;
  }
}
