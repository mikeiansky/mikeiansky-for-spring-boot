package io.github.mikeiansky.springboot.base.conditional;

import io.github.mikeiansky.utils.CollKit;
//import org.ian.anole.collection.CollectionUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author mike ian
 * @date 2025/5/22
 * @desc
 **/
public class ConditionalOnClassDemo {

    // 这样会导致 ConditionalOnClass 无法加载，从而失效
//    @ConditionalOnClass(value = CollKit.class)
    // 这样才能生效
//    @ConditionalOnClass(name = "io.github.mikeiansky.utils.CollKit")
//    @Configuration

    // 这里MyConfigFlag 配置的条件类不存在则无法注册
    @ComponentScan(basePackageClasses = MyConfigFlag.class)
    @Configuration
    public static class PackageScanConfiguration {

        // 这里的条件类不存在则无法注册
//        @ConditionalOnClass(value = CollectionUtils.class)
        @Component
        public static class ConditionalBeanFlag {

        }

    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PackageScanConfiguration.class);
        // 这样类不存在，还是可以注册
//        context.register(MyConfigFlag.class);
        context.refresh();

        PackageScanConfiguration.ConditionalBeanFlag conditionalBeanFlag = context.getBean(PackageScanConfiguration.ConditionalBeanFlag.class);
        System.out.println("conditionalBeanFlag : " + conditionalBeanFlag);
        MyConfigFlag myConfigFlag = context.getBean(MyConfigFlag.class);
        System.out.println("myConfigFlag : " + myConfigFlag);
        // NoClassDefFoundError, because of CollKit.class is not in classpath
        try {
            System.out.println("CollKit : " + CollKit.class);
        } catch (Error e) {
            e.printStackTrace();
        }

        System.out.println("complete ... ");
    }

}
