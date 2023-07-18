package com.bgr.dss.api.controllers;

import com.bgr.dss.core.ScheduleManager;
import com.bgr.dss.core.Scheduler;
import com.bgr.dss.core.domain.Job;
import com.bgr.dss.core.exceptions.JobScheduleFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/v1/api/scheduler")
public class SchedulerController {

    Scheduler scheduler = ScheduleManager.createScheduler();

    @PostMapping("/jobs")
    public ResponseEntity<Void> scheduleJob(@RequestBody Job job) throws JobScheduleFailureException {
        scheduler.schedule(job);
        return ResponseEntity.ok().build();
    }
}
