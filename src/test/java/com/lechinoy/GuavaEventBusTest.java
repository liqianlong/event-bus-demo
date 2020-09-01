package com.lechinoy;

import com.google.common.eventbus.EventBus;
import com.lechinoy.event.OrderEvent;
import com.lechinoy.guava.GuavaOrderCreateConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GuavaEventBusTest {

    @Autowired
    private EventBus guavaEventBus;

    @Autowired
    private GuavaOrderCreateConsumer guavaOrderCreateConsumer;


    @Test
    public void guavaEventBusTest(){

        guavaEventBus.register(guavaOrderCreateConsumer);
        guavaEventBus.post(new OrderEvent("AOrderType"));
        guavaEventBus.post(new OrderEvent("BOrderType"));


    }

}
