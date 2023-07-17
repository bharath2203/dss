package com.bgr.dss.core;

import com.bgr.dss.core.async.MessageConsumer;
import com.bgr.dss.core.async.MessageConsumerExecutor;
import com.bgr.dss.core.async.MessageProducer;
import com.bgr.dss.core.domain.Job;
import com.bgr.dss.core.exceptions.JobScheduleFailureException;
import com.bgr.dss.core.utils.MessageParser;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.concurrent.ExecutorService;

public class SchedulerImpl implements Scheduler{

    private final MessageProducer messageProducer;

    private final MessageParser messageParser = new MessageParser();

    public SchedulerImpl(MessageProducer messageProducer, MessageConsumer messageConsumer) {
        this.messageProducer = messageProducer;
        // Start the consumer to listen to the topic
        MessageConsumerExecutor messageConsumerExecutor = new MessageConsumerExecutor();
        messageConsumerExecutor.execute(messageConsumer);
    }

    @Override
    public void schedule(Job job) throws JobScheduleFailureException {
        try {
            messageProducer.send(messageParser.parseMessage(job));
            // Add success metrics and Logging
        } catch (JsonProcessingException e) {
            // Add metrics and Logging
            throw new JobScheduleFailureException("Failed to schedule job. Exception: ", e);
        }
    }
}
