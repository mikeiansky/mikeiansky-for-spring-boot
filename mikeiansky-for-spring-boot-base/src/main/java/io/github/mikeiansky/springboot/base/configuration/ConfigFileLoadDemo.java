package io.github.mikeiansky.springboot.base.configuration;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author mike ian
 * @date 2025/5/12
 * @desc
 **/
public class ConfigFileLoadDemo {

    public static void main(String[] args) throws IOException {

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/application.yml");
        String content = resource.getContentAsString(Charset.defaultCharset());
        System.out.println(content);

    }

}
