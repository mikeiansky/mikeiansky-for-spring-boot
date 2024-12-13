package io.github.mikeiansky.springboot.base.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
@Data
@ConfigurationProperties(prefix = "io.mikeiansky.simple.app")
public class SimpleAppProperties {

    private String name;
    private String version;

}
