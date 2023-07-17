package com.bgr.dss.core.utils;

import com.bgr.dss.core.domain.Job;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageParser {

    private final ObjectMapper objectMapper;

    public MessageParser() {
        this.objectMapper = new ObjectMapper();
    }

    public String parseMessage(Job job) throws JsonProcessingException {
        return objectMapper.writeValueAsString(job);
    }
}
