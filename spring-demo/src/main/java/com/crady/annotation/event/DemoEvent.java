package com.crady.annotation.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * @author :Crady
 * date :2020/03/22 20:20
 * desc : spring事件源类
 **/
@Slf4j
public class DemoEvent extends ApplicationEvent {

    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DemoEvent(Object source) {
        super(source);
    }

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public void print(){
        log.info("msg = {} ",msg);
    }
}
