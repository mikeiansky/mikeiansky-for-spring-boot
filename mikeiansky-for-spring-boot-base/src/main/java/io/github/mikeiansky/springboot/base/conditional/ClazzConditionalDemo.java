package io.github.mikeiansky.springboot.base.conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mike ian
 * @date 2025/5/13
 * @desc
 **/
public class ClazzConditionalDemo {

    public static class One {

    }

    public static class OneConditional {

    }

    @ConditionalOnMissingClass("io.github.mikeiansky.springboot.base.conditional.ClazzConditionalDemo$OneConditional")
    @Configuration
    public static class AppConfig {

//        @ConditionalOnClass(OneConditional.class)
        @Bean
        public static One oneBean() {
            return new One();
        }

    }

    public static void main(String[] args) {
        System.out.println(OneConditional.class.getName());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        AppConfig appConfig = context.getBean(AppConfig.class);
        System.out.println(appConfig);

        One one = context.getBean(One.class);
        System.out.println(one);


    }


}
