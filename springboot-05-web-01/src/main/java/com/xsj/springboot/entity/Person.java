package com.xsj.springboot.entity;


import lombok.Data;

import java.util.Date;

/**
 * @author TT
 * @Date 2021/1/4 16:50
 */
@Data
public class Person {

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;
}
