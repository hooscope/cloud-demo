package cn.itcast.member.pojo;

import lombok.Data;

@Data
public class Member {
    private Long id;

    private String name;
    private Integer orderId;
    private Integer level;
}