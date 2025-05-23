package io.github.mikeiansky.springboot.base.utils;

import java.io.File;

/**
 * @author mike ian
 * @date 2025/5/23
 * @desc
 **/
public class NormalTestDemo {

    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());

    }

}
