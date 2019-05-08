package com.gsy.luckymoney.controller;

import com.gsy.luckymoney.config.LimitConfig;
import com.gsy.luckymoney.enums.ResultEnum;
import com.gsy.luckymoney.exception.MoneyException;
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
    @Value("${limit.description}")
    private String description;
    @GetMapping("say")
    public String say(){

//        return "minMoney" + limitConfig.getMinMoney() + "说明 我还真的奇了怪了 热部署倒是有用了1zhihou "+description+limitConfig.getDescription()+"minMoney "+minMoney;
        throw new MoneyException(ResultEnum.UNKNOW_ERROR);
//        return  "index";
    }

}
