package com.gsy.luckymoney.controller;

import com.gsy.luckymoney.config.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private LimitConfig limitConfig;
    @Value("${limit.minMoney}")
    private BigDecimal minMoney;
    @GetMapping("say")
    public String say(){

        return "minMoney" + limitConfig.getMinMoney() + "说明 "+limitConfig.getDescription()+"minMoney "+minMoney;
//        return  "index";
    }

}
