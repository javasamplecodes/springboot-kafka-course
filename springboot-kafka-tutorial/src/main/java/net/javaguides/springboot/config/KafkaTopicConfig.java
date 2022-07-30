package net.javaguides.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaTopicConfig.class);

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;

    @Bean
    public NewTopic javaguidesTopic(){
        LOGGER.info(String.format("Topic % s will be added.", topicName));
        return TopicBuilder.name(topicName)
                .build();
    }

    @Bean
    public NewTopic javaguidesJsonTopic(){
        LOGGER.info(String.format("Topic (for JSON) %s will be added.", topicJsonName));
        return TopicBuilder.name(topicJsonName)
                .build();
    }
}
