package com.aleecoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author HuanyuLee
 * @date 2022/4/5
 */
@Controller
public class RestFul {
    @RequestMapping(value = "rest/{id}",method = RequestMethod.GET)
    public String get(@PathVariable("id") String id){
        System.out.println("id = " + id);
        return "success";
    }
}
