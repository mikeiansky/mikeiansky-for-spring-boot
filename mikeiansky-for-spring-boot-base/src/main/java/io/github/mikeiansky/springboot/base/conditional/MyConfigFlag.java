package io.github.mikeiansky.springboot.base.conditional;

import org.ian.anole.collection.CollectionUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author mike ian
 * @date 2025/5/22
 * @desc
 **/
//@ConditionalOnClass(value = CollKit.class)
//@ConditionalOnClass(name = "io.github.mikeiansky.utils.CollKit")
    // 使用spring-boot的加载方式可以进行加载，但是使用传统的spring是无法加载的，
// 因为spring-boot直接读取的字节码获取类的信息，并且将类转换为string
@ConditionalOnClass(value = CollectionUtils.class)
//@ConditionalOnClass(name = "org.ian.anole.collection.CollectionUtils")
//@ConditionalOnMissingClass(value = "io.github.mikeiansky.utils.CollKit")
@Configuration
public class MyConfigFlag {

    public static void test(){
        System.out.println(CollectionUtils.isEmpty(List.of()));
    }

}
