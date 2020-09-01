package com.lechinoy.configuration;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.lechinoy.handler.GuavaEventErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liqianlong
 * @date 2020/8/26 16:13
 */
@Configuration
public class GuavaEventBusConfiguration {



    @Bean("guavaExecutor")
    public ExecutorService getExecutor() {

        return new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(256),
                r -> new Thread(r, "order_event_pool_" + r.hashCode()),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Bean
    public GuavaEventErrorHandler getErrorHandler(){
        return new GuavaEventErrorHandler();
    }

    @Bean("guavaEventBus")
    public EventBus getEventBus(ExecutorService guavaExecutor,GuavaEventErrorHandler eventErrorHandler){

        return new AsyncEventBus(guavaExecutor,eventErrorHandler);
    }


}
