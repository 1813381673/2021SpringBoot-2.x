package com.xsj.springboot.controller;


import com.xsj.springboot.entity.Person;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author TT
 * @Date 2021/1/5 16:19
 */
@Controller
public class ResponseTestController {


    /**
     * 1.浏览器发送请求 直接返回xml  [application/xml]  jacksonXmlConverter
     * 2.如果是ajax请求  返回json  [application/json]  jacksonJsonConverter
     * 3.如果是 jiegegeAPP发请求，返回自定义协商数据    [application/x-jiege] xxxConverter
     *
     * 步骤：
     * 1.添加自定义的MessageConverter加入系统底层
     * 2.系统底层就会统计出所有MessageConverter能操作哪些类型数据
     * 3.客户端内容协商 [jiege---->jiege];
     * @return
     */
    @GetMapping("/test/person")
    @ResponseBody
    public Person getPerson(){
        Person person = new Person();
        person.setAge(18);
        person.setBirth(new Date());
        person.setUserName("张三");
        return person;
    }
}
