package com.lechinoy.configuration;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lechinoy.CallerRunsPolicyConfig;
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
public class SpringEventBusConfiguration {



    @Bean("springExecutor")
    public ExecutorService getExecutor() {

        return new ThreadPoolExecutor(2,
                5,
                60,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(256),
                new ThreadFactoryBuilder().setNameFormat("spring_order_event_pool_%d").build(),
                new CallerRunsPolicyConfig());
    }


}
