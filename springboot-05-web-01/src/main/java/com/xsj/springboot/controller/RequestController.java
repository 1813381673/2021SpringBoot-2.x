package com.xsj.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TT
 * @Date 2021/1/1 16:09
 */
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg", "成功");
        request.setAttribute("code", "200");
        return "forward:/success";
    }

    @GetMapping("/params")
    public String testParms(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("map","map 123");
        model.addAttribute("model","model 123");
        request.setAttribute("request", "request 123");

        Cookie cookie = new Cookie("c1","v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:" + "/success";
    }


    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg", required = false) String msg,
                       @RequestAttribute(value = "code", required = false) String code,
                       HttpServletRequest request){
        Map<String, Object> map = new HashMap();
        Object msg1 = request.getAttribute("msg");
        Object code1 = request.getAttribute("code");
        map.put("reqMethod_msg", msg1);
        map.put("reqMethod_code", code1);
        map.put("reqAttr_msg", msg);
        map.put("reqAttr_code", code);

        Object map1 = request.getAttribute("map");
        Object model = request.getAttribute("model");
        Object request1 = request.getAttribute("request");

        map.put("map", map1);
        map.put("model", model);
        map.put("request", request1);


        return map;
    }
}
