package com.gsy.luckymoney;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@MapperScan(basePackages = "com.gsy.luckymoney.mapper")
//打开定时任务
@EnableScheduling
//打开异步任务开关
@EnableAsync
public class LuckyMoneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuckyMoneyApplication.class, args);
    }

}
