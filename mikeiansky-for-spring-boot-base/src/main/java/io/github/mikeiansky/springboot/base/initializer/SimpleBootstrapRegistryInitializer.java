package io.github.mikeiansky.springboot.base.initializer;

import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;

/**
 * @author mike ian
 * @date 2025/5/12
 * @desc
 **/
public class SimpleBootstrapRegistryInitializer implements BootstrapRegistryInitializer {

    @Override
    public void initialize(BootstrapRegistry registry) {
        System.out.println("SimpleBootstrapRegistryInitializer : " + registry);
    }

}
