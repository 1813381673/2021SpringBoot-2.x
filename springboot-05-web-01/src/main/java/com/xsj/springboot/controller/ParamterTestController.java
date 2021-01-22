package com.xsj.springboot.controller;


import com.xsj.springboot.entity.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TT
 * @Date 2021/1/1 15:45
 */
@RestController
public class ParamterTestController {

    @PostMapping("/saveuser")
    public Person saveUser(Person person){
        return person;
    }

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String, String> parmas,
                                      @CookieValue("Pycharm-917e35ad") String ga,
                                      @CookieValue("Pycharm-917e35ad") Cookie cookie){
        Map<String, Object> map = new HashMap<>();
        /*map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        map.put("user-agent", userAgent);
        map.put("header", header);*/
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", parmas);
        // 注意cookieValue这个属性    查看你发送的请求中到底有没有这个cookieValue  没有就会报错
        map.put("Pycharm-917e35ad", ga);
        System.out.println(cookie);
        System.out.println(cookie.getName() + "------" + cookie.getValue());
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String, Object> map = new HashMap();
        map.put("content", content);
        return map;
    }
    // 1. 语法 /cars/sell;low=34;brand=byd,audi,yd
    // 2. SpringBoot默认是禁用了矩阵变量的功能
    //      需要手动开启,
    //      原理：对于路径的处理 UrlPathHelper进行解析
    //      removeSemiconlonContent（移除分号内容） 支持矩阵变量的
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable String path){

        Map<String, Object> map = new HashMap();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    //   /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossid}/{empid}")
    public Map boos(@MatrixVariable(value = "age",pathVar = "bossid") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empid") Integer empAge){
        Map<String, Object> map = new HashMap();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }
}
