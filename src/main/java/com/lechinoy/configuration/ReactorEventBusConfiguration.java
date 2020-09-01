package com.lechinoy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.Environment;
import reactor.bus.EventBus;
import reactor.core.dispatch.ThreadPoolExecutorDispatcher;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liqianlong
 * @date 2020/8/26 19:52
 */
@Configuration
public class ReactorEventBusConfiguration {


    @Bean
    public Environment env(){
        return Environment.initializeIfEmpty()
                .assignErrorJournal()
                .setDispatcher("orderDispatcher",
                        new ThreadPoolExecutorDispatcher(2,8,"orderReactor",
                                new LinkedBlockingQueue<>(256)
                                ,new ThreadPoolExecutor.CallerRunsPolicy()));
    }

    @Bean("reactorEventBus")
    public EventBus eventBus(Environment env){
        return EventBus.create(env,env.getDispatcher("orderDispatcher"));
    }


}
