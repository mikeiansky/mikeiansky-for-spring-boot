package io.github.mikeiansky.sb.sample.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author mike ian
 * @date 2024/12/27
 * @desc
 **/
@SpringBootApplication
public class SampleSbKafkaApp {

    public static void main(String[] args) {
        SpringApplication.run(SampleSbKafkaApp.class, args);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("test-topic")
                .partitions(10)
                .replicas(1)
                .build();
    }

    // 这里的 group 可以在配置文件里面创建
    @KafkaListener(topics = "test-topic")
    public void listen(String in) {
        System.out.println(in);
    }

}
