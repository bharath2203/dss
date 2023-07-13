package com.bgr.dss.core;

import com.bgr.dss.core.domain.Job;
import com.bgr.dss.core.exceptions.JobScheduleFailureException;

public interface Scheduler {

    void schedule(Job job) throws JobScheduleFailureException;

}
