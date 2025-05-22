package io.github.mikeiansky.springboot.base.conditional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author mike ian
 * @date 2025/5/22
 * @desc
 **/
@SpringBootApplication
public class ConditionalOnClassBootDemo {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConditionalOnClassBootDemo.class, args);
        try {
            MyConfigFlag myConfigFlag = context.getBean(MyConfigFlag.class);
            System.out.println("myConfigFlag222 : " + myConfigFlag);
        } catch (Error e) {
            e.printStackTrace();
        }

        System.out.println("before  MyConfigFlag.test() .... ");

        MyConfigFlag.test();
        System.out.println("complete .... ");
    }

}
