package io.github.mikeiansky.springboot.base.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mike ian
 * @date 2024/12/18
 * @desc
 **/
@ConfigurationProperties(prefix = "io.mikeiansky.simple.spring.base")
public class MyConfigurationProperties {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyConfigurationProperties() {
        System.out.println("MyConfigurationProperties instantiate");
    }

    public MyConfigurationProperties(String name, int age) {
        System.out.println("MyConfigurationProperties, constructor name ,age");
        this.name = name;
        this.age = age;
    }
}
