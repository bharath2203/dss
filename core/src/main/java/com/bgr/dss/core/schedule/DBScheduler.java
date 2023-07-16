package com.bgr.dss.core.schedule;

import com.bgr.dss.core.domain.DBScheduledJob;

public interface DBScheduler {
    void schedule(DBScheduledJob job);
}
