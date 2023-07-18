package com.bgr.dss.core.kafka;

import com.bgr.dss.core.utils.EnvironmentUtil;

import java.util.Properties;

public class PropertyConfig {

    public static Properties getProducerProperty() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all"); // 0, 1, all
        props.put("retries", 0); // 0, 1, 2, ...
        props.put("batch.size", 16384); // 0, 1, 2, ...
        props.put("linger.ms", 1); // 0, 1, 2, ...
        props.put("buffer.memory", 33554432); // 0, 1, 2, ...
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }

    public static Properties getConsumerProperty() {
        Properties props = new Properties();
//        props.put("bootstrap.servers", EnvironmentUtil.getProperty(Constants.BOOTSTRAP_SERVERS));
//        props.put("group.id", EnvironmentUtil.getProperty(Constants.GROUP_ID));
//        props.put("enable.auto.commit", EnvironmentUtil.getProperty(Constants.ENABLE_AUTO_COMMIT));
//        props.put("auto.commit.interval.ms", EnvironmentUtil.getProperty(Constants.AUTO_COMMIT_INTERVAL_MS));
//        props.put("session.timeout.ms", EnvironmentUtil.getProperty(Constants.SESSION_TIMEOUT_MS));
//        props.put("key.deserializer", EnvironmentUtil.getProperty(Constants.KEY_DESERIALIZER));
//        props.put("value.deserializer", EnvironmentUtil.getProperty(Constants.VALUE_DESERIALIZER));

        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all"); // 0, 1, all
        props.put("retries", 0); // 0, 1, 2, ...
        props.put("batch.size", 16384); // 0, 1, 2, ..
        props.put("group.id", "test-group"); // 0, 1, 2, ...
        props.put("linger.ms", 1); // 0, 1, 2, ...
        props.put("buffer.memory", 33554432); // 0, 1, 2, ...
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }
}
