package com.bestfei.springboot_basedemo.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(cron="*/6 * * * * ?")
//    private void scheduled1(){
//        System.out.println("每6秒，scheduled1 now time：" + dateFormat.format(new Date()));
//    }
//
//    @Scheduled(cron="6 * * * * ?")
//    private void scheduled2(){
//        System.out.println("每分钟第6秒,scheduled2 now time：" + dateFormat.format(new Date()));
//    }

}
