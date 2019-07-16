package com.leyou.userconsumeservice.dao;


import com.leyou.userconsumeservice.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserDao {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    @HystrixCommand(fallbackMethod="queryUserByIdFallback")
    public User queryUserById(Long id) {
        long beginTime = System.currentTimeMillis();
        String url = "http://user-service-demo/user/" + id;
        User user = restTemplate.getForObject(url, User.class);
        long end = System.currentTimeMillis();
        logger.info("访问用时为: {}",end-beginTime);
        return user;
    }

    public User queryUserByIdFallback(Long id){
        User user = new User();
        user.setId(id);
        user.setName("未查到该用户");
        return user;
    }
}
