package cn.itcast.member.service;

import cn.itcast.member.mapper.MemberMapper;
import cn.itcast.member.pojo.Member;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public Member queryByName(String username) {
        int count = count(username);
        Member byName = memberMapper.findByName(username);
        System.out.println(byName);
        return byName;
    }

    @Trace(operationName = "/count")
    public int count(String username) {
        // <X> 自定义 SkyWalking Span
        ActiveSpan.tag("mp", "业务处理核心");
        try {
            Thread.sleep(1200);
//            int a = 1/0;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return username.length();
    }
}