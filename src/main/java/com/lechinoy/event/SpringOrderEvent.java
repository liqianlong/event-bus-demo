package com.lechinoy.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author liqianlong
 * @date 2020/8/28 18:59
 */
public class SpringOrderEvent extends ApplicationEvent {

    private String content;

    public SpringOrderEvent(String content) {
        super(content);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
