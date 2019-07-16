package com.leyou.userconsumeservice.service;

import com.leyou.userconsumeservice.dao.UserDao;
import com.leyou.userconsumeservice.pojo.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zhuyunsheng
 * @Date: 2019/7/10 15:55
 */
@Service
public class UserService {

  @Autowired
  private RestTemplate restTemplat;
  @Autowired
  private DiscoveryClient discoveryClient;
  @Autowired
  private UserDao userDao;

  public List<User> queryUserByIds(List<Long> ids) {
    List<User> users = new ArrayList<>();
    // List<ServiceInstance> instances = discoveryClient.getInstances("user-service-demo");
    //ServiceInstance instance = instances.get(0);
    //String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/";
    String baseUrl = "http://user-service-demo/user/";
    ids.forEach(id -> {
      //users.add(this.restTemplat.getForObject(baseUrl + id,User.class));
     users.add(userDao.queryUserById(id)) ;
     /* try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }*/
    });
    return users;
  }
}
