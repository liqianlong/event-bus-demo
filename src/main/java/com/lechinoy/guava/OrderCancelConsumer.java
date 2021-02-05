package com.lechinoy.guava;

import com.lechinoy.event.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by liqianlong
 * 2021 2021/1/27 3:28 下午
 */
@Component
@Slf4j
public class OrderCancelConsumer extends AbstractGuavaConsumer {

    @Override
    void doHandler(OrderEvent orderEvent) {
        log.info("OrderCancelConsumer event:{}", orderEvent.getContent());
    }
}
