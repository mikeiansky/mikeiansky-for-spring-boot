package io.github.mikeiansky.springboot.base.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
@Data
@ConfigurationProperties(prefix = "io.mikeiansky.list")
public class ListAppProperties {

    @Data
    public static class App {
        private String name;
        private String version;
    }

    private List<App> app;

}
