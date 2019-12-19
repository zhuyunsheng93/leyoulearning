package com.wulaohei.miaosha.service;

import com.wulaohei.miaosha.dao.MiaoshaUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiaoShaUserServiceImpl implements MiaoshaUserService {
    @Autowired
    MiaoshaUserDao miaoshaUserDao;

}
