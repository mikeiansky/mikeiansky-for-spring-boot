package io.github.mikeiansky.springboot.base.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author mike ian
 * @date 2025/5/12
 * @desc
 **/
public class HelloEvent extends ApplicationEvent {


    public HelloEvent(Object source) {
        super(source);
    }
}
