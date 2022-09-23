package com.aleecoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HuanyuLee
 * @date 2022/4/3
 */
@Controller
public class MyController {
    //请求映射路径
    @RequestMapping("myController")
    @ResponseBody
    public String myController(){
        return "Hello Spring Boot";
    }
}
