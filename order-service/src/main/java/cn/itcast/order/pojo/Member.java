package cn.itcast.order.pojo;

import lombok.Data;

@Data
public class Member {
    private Long id;
    private Integer orderId;
    private Integer level;
}