package com.lechinoy.reactor;

import com.lechinoy.event.OrderEventData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;
import reactor.bus.selector.Selectors;
import reactor.fn.Consumer;

import javax.annotation.PostConstruct;

/**
 * @author liqianlong
 * @date 2020/8/26 19:46
 */
@Service
@Slf4j
public class ReactorCouponOrderCreateConsumer implements Consumer<Event<OrderEventData>> {


    @Autowired
    private EventBus reactorEventBus;

    /**
     * 注册
     */
    @PostConstruct
    public void register(){
        reactorEventBus.on(Selectors.$(ReactorConsumerKey.ORDER_CREATE_COUPON_CONSUMER),this);
    }


    @Override
    public void accept(Event<OrderEventData> orderEventDataEvent) {

        log.info("order create event coupon,orderType:{}",orderEventDataEvent.getData().getContent());

    }

}
