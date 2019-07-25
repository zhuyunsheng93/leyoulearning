package com.leyou.security.dao;

import com.leyou.security.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/7/15 10:37
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
  SysUser findByUsername(String username);
}
