package com.bgr.dss.core.executor;

import com.bgr.dss.core.domain.DBScheduledJob;

public interface JobExecutor {
    void execute(DBScheduledJob job);
}
