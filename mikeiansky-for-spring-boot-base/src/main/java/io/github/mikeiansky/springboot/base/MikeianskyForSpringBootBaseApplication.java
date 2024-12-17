package io.github.mikeiansky.springboot.base;

import io.github.mikeiansky.springboot.base.configuration.ConditionalConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MikeianskyForSpringBootBaseApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MikeianskyForSpringBootBaseApplication.class, args);

        ConditionalConfiguration.MissClassComponent missClassComponent = context.getBean(ConditionalConfiguration.MissClassComponent.class);
        System.out.println(missClassComponent);

    }

}
