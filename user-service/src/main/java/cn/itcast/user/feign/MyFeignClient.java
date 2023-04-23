package cn.itcast.user.feign;

import cn.itcast.user.pojo.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author wuhao
 * @Date 2023/4/21 15:52
 */

@FeignClient(name = "memberservice")
public interface MyFeignClient {

    @GetMapping("/member/{name}")
    Member queryById(@PathVariable("name") String username);
}
