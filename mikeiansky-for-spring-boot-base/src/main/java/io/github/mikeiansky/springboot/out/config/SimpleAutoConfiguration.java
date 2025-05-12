package io.github.mikeiansky.springboot.out.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author mike ian
 * @date 2025/5/12
 * @desc
 **/
@Configuration
public class SimpleAutoConfiguration {

    public SimpleAutoConfiguration() {
        System.out.println("SimpleAutoConfiguration instantiate");
    }
}
