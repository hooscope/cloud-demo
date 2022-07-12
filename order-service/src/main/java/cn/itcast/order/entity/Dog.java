package cn.itcast.order.entity;

import lombok.Data;

@Data
public class Dog {
    private String name;
    private String color;
    private int age;

    public Dog(String xiaohei, String black, int i) {
        super();
        this.name = name;
        this.color = color;
        this.age = age;
    }
}
