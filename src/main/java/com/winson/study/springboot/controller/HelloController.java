package com.winson.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author winson
 * @date 2021/5/31
 **/
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        System.out.println("Hello World");
        return "hello world";
    }

}
