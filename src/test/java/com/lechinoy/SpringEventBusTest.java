package com.lechinoy;

import com.lechinoy.event.SpringOrderEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @author liqianlong
 * @date 2020/9/1 16:13
 */
@SpringBootTest
public class SpringEventBusTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void springEventBusTest(){

        applicationContext.publishEvent(new SpringOrderEvent("AOrderType"));
        applicationContext.publishEvent(new SpringOrderEvent("BOrderType"));


    }

}
