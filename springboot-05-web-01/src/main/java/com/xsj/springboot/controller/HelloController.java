package com.xsj.springboot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TT
 * @Date 2020/12/30 15:17
 */
@RestController
public class HelloController {

    @RequestMapping("/1.jpg")
    public String hello(){
        return "aaa";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }

}
