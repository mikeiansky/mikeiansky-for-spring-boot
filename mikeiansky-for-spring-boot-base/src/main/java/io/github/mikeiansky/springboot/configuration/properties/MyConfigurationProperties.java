package io.github.mikeiansky.springboot.configuration.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mike ian
 * @date 2025/6/8
 * @desc
 **/
@Data
@ImportAutoConfiguration
@ConfigurationProperties(prefix = "my.properties")
public class MyConfigurationProperties {

    private String name;

    private String hello;

}
