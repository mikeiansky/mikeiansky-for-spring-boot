package io.github.mikeiansky.springboot.base;

import io.github.mikeiansky.springboot.base.configuration.ConditionalConfiguration;
import io.github.mikeiansky.springboot.base.event.HelloEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
public class MikeianskyForSpringBootBaseApplication {

    public static void main(String[] args) throws Exception {
//        String className = "io.github.mikeiansky.springboot.base.initializer.SimpleApplicationListener";
//        String className = "io.github.mikeiansky.springboot.base.initializer.SimpleBootstrapRegistryInitializer";
//        Class<?> clazz = Class.forName(className);
//        Object instance = clazz.getDeclaredConstructors()[0].newInstance();
//        System.out.println(instance);

        ApplicationContext context = SpringApplication.run(MikeianskyForSpringBootBaseApplication.class, args);
        context.publishEvent(new HelloEvent("Hello World!"));
//        ConditionalConfiguration.MissClassComponent missClassComponent = context.getBean(ConditionalConfiguration.MissClassComponent.class);
//        System.out.println(missClassComponent);


    }

}
