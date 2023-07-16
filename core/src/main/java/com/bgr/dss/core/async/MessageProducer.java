package com.bgr.dss.core.async;

public interface MessageProducer {
    void send(String topic, String message);
}
