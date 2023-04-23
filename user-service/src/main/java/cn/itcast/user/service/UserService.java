package cn.itcast.user.service;

import cn.itcast.user.feign.MyFeignClient;
import cn.itcast.user.mapper.UserMapper;
import cn.itcast.user.pojo.Member;
import cn.itcast.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MyFeignClient myFeignClient;

    public User queryById(Long id) {

        User user = userMapper.findById(id);
        // 2.利用RestTemplate发起http请求，查询用户
        // 2.1.url路径
//        String url = "http://memberservice/member/" + user.getUsername();
//        // 2.2.发送http请求，实现远程调用
//        Member member = restTemplate.getForObject(url, Member.class);
        // 3.封装user到Order;
        Member member = myFeignClient.queryById(user.getUsername());
        user.setMember(member);
        return user;
    }
}