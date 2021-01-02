package com.xsj.springboot.controller;


import com.xsj.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TT
 * @Date 2020/12/30 14:55
 */
@RestController
public class HelloController {
    @Autowired
    private Person person;

    @RequestMapping("/person")
    public Person person(){
        return person;
    }
}
