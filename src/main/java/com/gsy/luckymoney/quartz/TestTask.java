package com.gsy.luckymoney.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestTask {
//    @Scheduled(fixedRate = 3000)
    @Scheduled(cron = "4-40 * * * * ? ")
    public void say(){
        System.out.println(new Date());
    }
}
