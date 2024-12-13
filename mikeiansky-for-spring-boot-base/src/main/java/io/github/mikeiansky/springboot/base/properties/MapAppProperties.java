package io.github.mikeiansky.springboot.base.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
@Data
@ConfigurationProperties(prefix = "io.mikeiansky.map")
public class MapAppProperties {

    public enum Type {
        WEB,
        SERVER,
        CLIENT
    }

    @Data
    public static class App {
        private String name;
        private String version;
    }

    private Map<Type, App> typeApp;

    private Map<String, App> normalApp;

}
