package io.github.mikeiansky.springboot.base;

import io.github.mikeiansky.springboot.base.configuration.ConditionalConfiguration;
import io.github.mikeiansky.springboot.base.custom.spl.CustomSpringLoaderObject;
import io.github.mikeiansky.springboot.base.event.HelloEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.util.ClassUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

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


        SpringFactoriesLoader springFactoriesLoader = SpringFactoriesLoader.forDefaultResourceLocation(ClassUtils.getDefaultClassLoader());
        System.out.println("custom load application context initializer ... ");
        List<ApplicationContextInitializer> applicationContextInitializerList = springFactoriesLoader.load(ApplicationContextInitializer.class);
        for (ApplicationContextInitializer applicationContextInitializer : applicationContextInitializerList) {
            System.out.println(applicationContextInitializer);
        }
        System.out.println("custom load spring load object ... ");
        List<CustomSpringLoaderObject> customSpringLoaderObjectList = springFactoriesLoader.load(CustomSpringLoaderObject.class);
        for (CustomSpringLoaderObject customSpringLoaderObject : customSpringLoaderObjectList) {
            System.out.println(customSpringLoaderObject);
        }

    }

}
