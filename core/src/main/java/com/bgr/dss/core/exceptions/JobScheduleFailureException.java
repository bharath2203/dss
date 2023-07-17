package com.bgr.dss.core.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JobScheduleFailureException extends Exception {
    public JobScheduleFailureException(String message, JsonProcessingException e) {
        super(message, e);
    }
}
