package io.github.mikeiansky.springboot.base.utils;

import cn.hutool.core.util.HexUtil;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HexFormat;

/**
 * @author mike ian
 * @date 2025/5/12
 * @desc
 **/
public class ResourceUrlDemo {

    public static void main(String[] args) throws Exception {

        String className = ResourceUrlDemo.class.getName();
        className = String.class.getName();
        System.out.println(className);
        System.out.println(File.separator);
        String classFile = className.replaceAll("\\.", "/");
        classFile += ".class";
        System.out.println(classFile);
//        classFile = "META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports";
        Enumeration<URL> urlEnumeration = ResourceUrlDemo.class.getClassLoader().getResources(classFile);

        ResourceLoader resourceLoader = new DefaultResourceLoader();

        while (urlEnumeration.hasMoreElements()) {
            URL url = urlEnumeration.nextElement();
//            System.out.println(url);

//            resourceLoader.getResource(url.getPath());
//            System.out.println(url.getPath());

            UrlResource urlResource = new UrlResource(url);
            System.out.println(urlResource);
            System.out.println(new String(HexUtil.encodeHex(urlResource.getContentAsByteArray())));
//            String content = urlResource.getContentAsString(Charset.defaultCharset());
//            System.out.println(content);

        }

    }

}
