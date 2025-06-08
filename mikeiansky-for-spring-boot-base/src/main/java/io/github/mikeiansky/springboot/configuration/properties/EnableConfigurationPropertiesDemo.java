package io.github.mikeiansky.springboot.configuration.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author mike ian
 * @date 2025/6/8
 * @desc
 **/
@SpringBootApplication
public class EnableConfigurationPropertiesDemo {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EnableConfigurationPropertiesDemo.class, args);
        MyConfigurationProperties myConfigurationProperties = context.getBean(MyConfigurationProperties.class);
        System.out.println(myConfigurationProperties);
    }

}
