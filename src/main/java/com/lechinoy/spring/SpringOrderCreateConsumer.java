package com.lechinoy.spring;

import com.lechinoy.event.SpringOrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author liqianlong
 * @date 2020/8/28 19:05
 */
@Component
@Slf4j
public class SpringOrderCreateConsumer {

    @EventListener
    public void coupon(SpringOrderEvent springOrderEvent){
        log.info("order create event coupon,orderType:{}",springOrderEvent.getContent());
    }

    @Async("springExecutor")
    @EventListener
    public void stock(SpringOrderEvent springOrderEvent){
        log.info("order create event stock,orderType:{}",springOrderEvent.getContent());
    }



}
