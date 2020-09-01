package com.lechinoy.handler;

import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liqianlong
 * @date 2020/8/26 16:49
 */
@Slf4j
public class GuavaEventErrorHandler implements SubscriberExceptionHandler {

    @Override
    public void handleException(Throwable exception, SubscriberExceptionContext context) {
        log.error("{},error",context.getEvent().toString());
    }
}
