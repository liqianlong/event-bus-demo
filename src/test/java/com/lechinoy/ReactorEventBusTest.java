package com.lechinoy;

import com.lechinoy.event.OrderEventData;
import com.lechinoy.reactor.ReactorConsumerKey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.bus.Event;
import reactor.bus.EventBus;

/**
 * @author liqianlong
 * @date 2020/8/26 20:33
 */
@SpringBootTest
public class ReactorEventBusTest {

    @Autowired
    private EventBus reactorEventBus;

    @Test
    public void reactorEventBusTest(){
        reactorEventBus.notify(ReactorConsumerKey.ORDER_CREATE_COUPON_CONSUMER, Event.wrap(new OrderEventData("AOrderType")));
        reactorEventBus.notify(ReactorConsumerKey.ORDER_CREATE_STOCK_CONSUMER, Event.wrap(new OrderEventData("AOrderType")));
        reactorEventBus.notify(ReactorConsumerKey.ORDER_CREATE_COUPON_CONSUMER, Event.wrap(new OrderEventData("BOrderType")));
        reactorEventBus.notify(ReactorConsumerKey.ORDER_CREATE_STOCK_CONSUMER, Event.wrap(new OrderEventData("BOrderType")));
    }

}
