package io.github.mikeiansky.sb.mq;

import io.github.mikeiansky.sb.mq.rocket.RocketmqSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MikeianskyForSpringBootMqApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(MikeianskyForSpringBootMqApplication.class, args);
        RocketmqSender sender = context.getBean(RocketmqSender.class);
        sender.sendMessage();
        System.out.println("mq test complete ... ");
        Thread.sleep(5000);
        System.out.println("app complete ... ");
    }

}
