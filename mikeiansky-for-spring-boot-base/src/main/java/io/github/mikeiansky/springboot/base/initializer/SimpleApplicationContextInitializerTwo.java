package io.github.mikeiansky.springboot.base.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author mike ian
 * @date 2025/5/12
 * @desc
 **/
public class SimpleApplicationContextInitializerTwo implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("SimpleApplicationContextInitializerTwo : " + applicationContext);
    }

}
