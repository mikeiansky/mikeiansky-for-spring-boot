package io.github.mikeiansky.sb.mq.rocket;

import org.apache.rocketmq.client.core.RocketMQClientTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author mike ian
 * @date 2025/7/21
 * @desc
 **/
@Service
public class RocketmqSender {

    private final RocketMQClientTemplate rocketMQClientTemplate;

    public RocketmqSender(RocketMQClientTemplate rocketMQClientTemplate) {
        this.rocketMQClientTemplate = rocketMQClientTemplate;
    }

    public void sendMessage() {
        byte[] bytes = "这是一个字符串".getBytes(StandardCharsets.UTF_8);
        Message<byte[]> message = MessageBuilder.withPayload(bytes)
                .build();
        rocketMQClientTemplate.send("topic_test", message);
    }

}
