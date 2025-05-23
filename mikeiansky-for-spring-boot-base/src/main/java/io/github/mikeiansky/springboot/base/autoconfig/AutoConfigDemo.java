package io.github.mikeiansky.springboot.base.autoconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author mike ian
 * @date 2025/5/23
 * @desc
 **/
@SpringBootApplication
public class AutoConfigDemo {

    @Configuration
    public static class MyAutoConfig {

    }

    public static void main(String[] args) {
        // 这个会进行自动配置
         SpringApplication.run(AutoConfigDemo.class, args);
    }

}
