package com.bgr.dss.core.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Job {
    private String name;
    private String description;
    private ScheduleType scheduleType;
    private String cronExpression;
    private JobType jobType;
    private HttpJobDescriptor httpJobDescriptor;
    private BashJobDescriptor bashJobDescriptor;
}
