package com.gsy.luckymoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LuckyMoneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuckyMoneyApplication.class, args);
    }

}
