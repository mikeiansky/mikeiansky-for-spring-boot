package io.github.mikeiansky.sb.web.controller;

import io.github.mikeiansky.sb.web.exception.BizException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mike ian
 * @date 2025/6/8
 * @desc
 **/
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(String msg) {
        if (1== 1){
            throw new BizException("test");
        }
        System.out.println("HelloController hello method called with msg: " + msg);
        return "hello : " + msg;
    }

}
