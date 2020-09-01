package com.lechinoy.guava;

/**
 * @author liqianlong
 * @date 2020/8/26 18:03
 */

import com.google.common.eventbus.Subscribe;
import com.lechinoy.event.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GuavaOrderCreateConsumer {


    @Subscribe
    public void stock(OrderEvent orderEvent) {
        log.info("handler orderType:{} stock", orderEvent.getContent());
    }

    //添加subscribe GuavaEventBus会调用这些方法
    @Subscribe
    public void coupon(OrderEvent orderEvent) {
        if ("BOrderType".equals(orderEvent.getContent())) {
            throw new RuntimeException();
        }
        log.info("handler orderType:{} coupon", orderEvent.getContent());
    }

}
