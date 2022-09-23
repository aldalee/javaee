package com.aleecoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 处理器Handler
 *
 * @author HuanyuLee
 * @date 2022/4/4
 */
@Controller
public class MyController {

    /**
     * 定义处理请求的方法
     *
     * @return java.lang.String 用来表明要跳转的页面的路径
     */
    @RequestMapping("/test")
    public String myController() {
        System.out.println("===== myController =====");
        return "test";
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String testRequest() {
        System.out.println("===== testRequest =====");
        return "test";
    }

    @RequestMapping(value = "/params", params = {"username", "password"})
    public String testParams() {
        System.out.println("===== testParams =====");
        return "test";
    }

    // 报错
    @RequestMapping(value = "/headers", headers = {"Accept-Encoding: gzip, deflate, br"}, method = RequestMethod.GET)
    public String testHeaders() {
        System.out.println("===== testHeaders =====");
        return "test";
    }
}
