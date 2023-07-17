package com.bgr.dss.core;

import com.bgr.dss.core.async.MessageConsumer;
import com.bgr.dss.core.async.MessageProducer;
import com.bgr.dss.core.async.MessageProducerDefaultImpl;

import java.util.List;

public class ScheduleManager {

    private final String topic = "test-topic";

    public Scheduler createScheduler() {
        // Dependencies
        MessageProducer producer = new MessageProducerDefaultImpl(topic);
        MessageConsumer messageConsumer = new MessageConsumer(List.of(topic));
        return new SchedulerImpl(producer);
    }
}
