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
public class OrderCreateConsumer extends AbstractGuavaConsumer {

    @Override
    void doHandler(OrderEvent orderEvent) {
        log.info("OrderCreateConsumer event:{}", orderEvent.getContent());
    }
}
