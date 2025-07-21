package io.github.mikeiansky.sb.mq.rocket;

import org.apache.rocketmq.client.annotation.RocketMQMessageListener;
import org.apache.rocketmq.client.apis.consumer.ConsumeResult;
import org.apache.rocketmq.client.apis.message.MessageView;
import org.apache.rocketmq.client.core.RocketMQClientTemplate;
import org.apache.rocketmq.client.core.RocketMQListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author mike ian
 * @date 2025/7/21
 * @desc
 **/
@Service
@RocketMQMessageListener(consumerGroup = "MyTopic-service", topic = "topic_test", tag = "*")
public class RocketmqConsumer implements RocketMQListener {

    public RocketmqConsumer() {

        System.out.println("create rocket mq consumer ");
    }

    @Override
    public ConsumeResult consume(MessageView messageView) {
        System.out.println("consumer ---------> ");
        // 从 MessageView 中获取 ByteBuffer
        ByteBuffer byteBuffer = messageView.getBody();

        // 转换 ByteBuffer 为字节数组
        byte[] body = new byte[byteBuffer.remaining()];
        byteBuffer.get(body);

        // 处理字节数组，例如转换为字符串
        String messageBody = new String(body, StandardCharsets.UTF_8);

        System.out.println("消费消息内容：" + messageBody);

        return ConsumeResult.SUCCESS;
    }

}
