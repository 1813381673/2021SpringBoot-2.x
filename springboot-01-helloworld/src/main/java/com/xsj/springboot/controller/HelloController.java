package com.xsj.springboot.controller;


import com.xsj.springboot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TT
 * @Date 2020/12/29 19:52
 */
@RestController
public class HelloController {
    @Autowired
    private Car car;

    @RequestMapping("/hello")
    public String handle01(){
        return "hello Spring Boot 2!";
    }

    @RequestMapping("/car")
    public Car car(){
        return car;
    }
}
