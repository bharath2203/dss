package com.bgr.dss.core.async;

import com.bgr.dss.core.kafka.PropertyConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.logging.Logger;

public class MessageProducerDefaultImpl implements MessageProducer {

    private static final Logger LOGGER = Logger.getLogger(MessageProducerDefaultImpl.class.getName());

    private final KafkaProducer<String, String> producer;

    public MessageProducerDefaultImpl() {
        super();
        producer = new KafkaProducer<>(PropertyConfig.getProducerProperty());
    }

    @Override
    public void send(String topic, String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
        producer.send(record, (metadata, exception) -> {
            if (exception != null) {
                LOGGER.severe("Error while sending message to kafka topic: " + topic + " message: " + message);
            }
        });
    }
}
