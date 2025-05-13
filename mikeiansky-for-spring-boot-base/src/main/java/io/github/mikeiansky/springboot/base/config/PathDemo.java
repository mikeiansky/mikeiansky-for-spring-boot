package io.github.mikeiansky.springboot.base.config;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

/**
 * @author mike ian
 * @date 2025/5/13
 * @desc
 **/
public class PathDemo {

    public static void main(String[] args) {
        String currentDir = System.getProperty("user.dir");
        System.out.println("当前运行目录: " + currentDir);


        String file = "file:./temp.txt";
        String file2 = "file:temp.txt";
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(file);
        System.out.println(resource.exists());
    }

}
