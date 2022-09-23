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
public class PathController {

    @RequestMapping(value = "path/{id}/{username}" ,method = RequestMethod.GET)
    public String pathVariable(@PathVariable("id") String id, @PathVariable("username") String username) {
        System.out.println("id = " + id);
        System.out.println("username = " + username);
        System.out.println("======pathVariable======");
        return "success";
    }
}
