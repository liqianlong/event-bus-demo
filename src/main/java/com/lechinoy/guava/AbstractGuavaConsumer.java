package com.lechinoy.guava;

import com.google.common.eventbus.Subscribe;
import com.lechinoy.event.OrderEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by liqianlong
 * 2021 2021/1/27 3:26 下午
 */
@Slf4j
public abstract class AbstractGuavaConsumer {

    @Subscribe
    void handler(OrderEvent orderEvent) {
        log.info("AbstractGuavaConsumer orderType:{} ", orderEvent.getContent());
        doHandler(orderEvent);
    }

    abstract void doHandler(OrderEvent orderEvent);

}
