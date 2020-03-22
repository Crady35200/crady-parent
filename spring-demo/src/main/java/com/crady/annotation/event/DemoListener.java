package com.crady.annotation.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author :Crady
 * date :2020/03/22 20:21
 * desc : spring事件监听器
 **/
@Component
@Slf4j
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent event) {
        log.info("DemoListener is invoke...");
        event.print();
    }
}
