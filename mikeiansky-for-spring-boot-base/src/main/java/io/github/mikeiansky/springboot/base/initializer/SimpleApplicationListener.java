package io.github.mikeiansky.springboot.base.initializer;

import io.github.mikeiansky.springboot.base.event.HelloEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author mike ian
 * @date 2025/5/12
 * @desc
 **/
public class SimpleApplicationListener implements ApplicationListener<HelloEvent> {

//    public SimpleApplicationListener() {
//        System.out.println("SimpleApplicationListener constructor");
//    }

    @Override
    public void onApplicationEvent(HelloEvent event) {
        System.out.println("SimpleApplicationListener onApplicationEvent : " + event);
    }

}
