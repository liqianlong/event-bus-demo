package com.lechinoy;

import com.google.common.eventbus.EventBus;
import com.lechinoy.event.OrderEvent;
import com.lechinoy.guava.GuavaOrderCreateConsumer;
import com.lechinoy.guava.OrderCancelConsumer;
import com.lechinoy.guava.OrderCreateConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GuavaEventBusTest {

    @Autowired
    private EventBus guavaEventBus;

    @Autowired
    private GuavaOrderCreateConsumer guavaOrderCreateConsumer;

    @Autowired
    private OrderCreateConsumer orderCreateConsumer;

    @Autowired
    private OrderCancelConsumer orderCancelConsumer;

    @Test
    public void guavaEventBusTest() {

        guavaEventBus.register(guavaOrderCreateConsumer);
        guavaEventBus.post(new OrderEvent("AOrderType"));
        guavaEventBus.post(new OrderEvent("BOrderType"));

    }

    @Test
    public void abstractEventTest() {

        guavaEventBus.register(orderCreateConsumer);
        guavaEventBus.register(orderCancelConsumer);
        guavaEventBus.post(new OrderEvent("AOrderType"));

    }

}
