package com.bgr.dss.api.controllers;

import com.bgr.dss.core.domain.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("v1/api/scheduler")
public class SchedulerController {

    @PostMapping("/jobs")
    public ResponseEntity<Void> scheduleJob(@RequestBody Job job) {
        return ResponseEntity.ok().build();
    }
}
