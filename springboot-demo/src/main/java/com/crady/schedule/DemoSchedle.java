package com.crady.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author :Crady
 * date :2019/8/14 16:15
 * desc :
 **/
@Component
@Slf4j
public class DemoSchedle {


    /**
     * 固定频率执行---定时任务每五秒执行一次
     */
    @Scheduled(fixedRate = 1000*5)
    public void every5Second(){
        log.info("********************定时任务每五秒执行一次***********************");
    }

    /**
     * 固定时间点执行---定时任务每个小时的第20分钟执行一次
     */
    @Scheduled(cron = "0 20 * * * ?")
    public void everyHourAt20Min(){
        log.info("********************定时任务每个小时的第20分钟执行一次***********************");
    }
}
