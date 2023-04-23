package cn.itcast.member.web;

import cn.itcast.member.pojo.Member;
import cn.itcast.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberrController {

    @Autowired
    private MemberService memberService;

    /**
     * 路径： /user/110
     *
     * @param username 用户姓名
     * @return 用户
     */
    @GetMapping("/{name}")
    public Member queryById(@PathVariable("name") String username) {
        return memberService.queryByName(username);
    }
}
