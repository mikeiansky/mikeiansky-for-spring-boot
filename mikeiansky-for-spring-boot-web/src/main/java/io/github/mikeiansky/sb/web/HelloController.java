package io.github.mikeiansky.sb.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        System.out.println("HelloController hello method called with msg: " + msg);
        return "hello : " + msg;
    }

}
