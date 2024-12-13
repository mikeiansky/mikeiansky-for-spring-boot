package io.github.mikeiansky.springboot.base.properties;

import io.github.mikeiansky.springboot.base.component.ListAppComponent;
import io.github.mikeiansky.springboot.base.component.MapAppComponent;
import io.github.mikeiansky.springboot.base.component.SimpleAppComponent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mike ian
 * @date 2024/12/13
 * @desc
 **/
@EnableConfigurationProperties({
        SimpleAppProperties.class,
        ListAppProperties.class,
        MapAppProperties.class
})
@Configuration
public class AppConfig {

    @Bean
    public SimpleAppComponent simpleAppComponent(SimpleAppProperties simpleAppProperties) {
        SimpleAppComponent simpleAppComponent = new SimpleAppComponent();
        simpleAppComponent.setSimpleAppProperties(simpleAppProperties);
        return simpleAppComponent;
    }

    @Bean
    public ListAppComponent listAppComponent(ListAppProperties listAppProperties) {
        ListAppComponent listAppComponent = new ListAppComponent();
        listAppComponent.setListAppProperties(listAppProperties);
        return listAppComponent;
    }

    @Bean
    public MapAppComponent mapAppComponent(MapAppProperties mapAppProperties) {
        MapAppComponent mapAppComponent = new MapAppComponent();
        mapAppComponent.setMapAppProperties(mapAppProperties);
        return mapAppComponent;
    }

}
