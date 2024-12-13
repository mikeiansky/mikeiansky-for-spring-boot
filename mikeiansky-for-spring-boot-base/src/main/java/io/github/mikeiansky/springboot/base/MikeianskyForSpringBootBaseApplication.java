package io.github.mikeiansky.springboot.base;

import io.github.mikeiansky.springboot.base.component.ListAppComponent;
import io.github.mikeiansky.springboot.base.component.MapAppComponent;
import io.github.mikeiansky.springboot.base.component.SimpleAppComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MikeianskyForSpringBootBaseApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MikeianskyForSpringBootBaseApplication.class, args);
        SimpleAppComponent simpleAppComponent = context.getBean(SimpleAppComponent.class);
        System.out.println(simpleAppComponent);
        ListAppComponent listAppComponent = context.getBean(ListAppComponent.class);
        System.out.println(listAppComponent);
        MapAppComponent mapAppComponent = context.getBean(MapAppComponent.class);
        System.out.println(mapAppComponent);
    }

}
