package com.lechinoy;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liqianlong
 * @date 2020/9/1 16:45
 */
@Slf4j
public class CallerRunsPolicyConfig implements RejectedExecutionHandler {

    public CallerRunsPolicyConfig() { }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (!executor.isShutdown()) {
            log.error("thread call callerRunsPolicy");
            r.run();
        }
    }
}
