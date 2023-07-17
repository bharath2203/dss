package com.bgr.dss.core.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MessageConsumerExecutor {

    private final ExecutorService executorService;

    public MessageConsumerExecutor() {
        this.executorService = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    public void execute(Runnable runnable) {
        executorService.execute(runnable);
    }
}
