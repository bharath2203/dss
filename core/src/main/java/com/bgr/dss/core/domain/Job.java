package com.bgr.dss.core.domain;

public class Job {
    private String name;
    private String description;
    private ScheduleType scheduleType;
    private String cronExpression;
    private JobType jobType;
    private HttpJobDescriptor httpJobDescriptor;
    private BashJobDescriptor bashJobDescriptor;
}
