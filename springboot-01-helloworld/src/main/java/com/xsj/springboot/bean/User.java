package com.xsj.springboot.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author TT
 * @Date 2020/12/29 20:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private Pet pet;
    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
