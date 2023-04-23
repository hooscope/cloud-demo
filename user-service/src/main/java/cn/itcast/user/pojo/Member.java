package cn.itcast.user.pojo;

import lombok.Data;

@Data
public class Member {
    private Long id;
    private Integer orderId;
    private Integer level;
}