package com.bgr.dss.core.async;

import com.bgr.dss.core.kafka.PropertyConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

/**
 * Default implementation of {@link MessageConsumer}
 * Uses kafka to consume messages
 */
public class MessageConsumerDefaultImpl implements MessageConsumer {

    private static final Logger LOGGER = Logger.getLogger(MessageConsumerDefaultImpl.class.getName());

    private final KafkaConsumer<String, String> consumer;

    public MessageConsumerDefaultImpl(List<String> topics) {
        super();
        this.consumer = new KafkaConsumer<String, String>(PropertyConfig.getConsumerProperty());
        this.consumer.subscribe(topics);
    }

    @Override
    public void listen() {
        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord<String, String> record : records) {
                LOGGER.info("Received message: " + record.value());
            }
        }
    }
}
