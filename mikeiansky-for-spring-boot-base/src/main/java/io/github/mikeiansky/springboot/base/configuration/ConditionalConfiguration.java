package io.github.mikeiansky.springboot.base.configuration;

import io.github.mikeiansky.utils.CollKit;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author mike ian
 * @date 2024/12/17
 * @desc
 **/
@EnableConfigurationProperties(MyConfigurationProperties.class)
@Configuration
public class ConditionalConfiguration {

    @ConditionalOnClass(value = CollKit.class)
    @Component
    public static class MissClassComponent {

    }


}
