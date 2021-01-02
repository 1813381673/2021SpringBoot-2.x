package com.xsj.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") String code,
                       HttpServletRequest request){
        Map<String, Object> map = new HashMap();
        Object msg1 = request.getAttribute("msg");
        Object code1 = request.getAttribute("code");
        map.put("reqMethod_msg", msg1);
        map.put("reqMethod_code", code1);
        map.put("reqAttr_msg", msg);
        map.put("reqAttr_code", code);
        return map;
    }
}
