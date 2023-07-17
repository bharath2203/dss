package com.bgr.dss.core.async;

import com.bgr.dss.core.kafka.PropertyConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

/**
 * Default implementation of {@link MessageConsumer}
 * Uses kafka to consume messages
 */
public class MessageConsumer implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(MessageConsumer.class.getName());

    private final KafkaConsumer<String, String> consumer;

    public MessageConsumer(List<String> topics) {
        super();
        this.consumer = new KafkaConsumer<String, String>(PropertyConfig.getConsumerProperty());
        this.consumer.subscribe(topics);
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            while(true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for(ConsumerRecord<String, String> record : records) {
                    LOGGER.info("Received message: " + record.value());
                }
            }
        } catch (WakeupException e) {
            // Logger for shutdown signal
        } finally {
            consumer.close();
        }
    }

    public void shutDown() {
        // The wakeup() method is used
        // to interrupt consumer.poll()
        // It will throw WakeUpException
        consumer.wakeup();
    }
}
