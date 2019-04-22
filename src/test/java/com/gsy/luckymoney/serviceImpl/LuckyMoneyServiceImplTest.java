package com.gsy.luckymoney.serviceImpl;

import com.gsy.luckymoney.entity.Luckymoney;
import com.gsy.luckymoney.service.LuckyMoneyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest//将启动整个spring工程
public class LuckyMoneyServiceImplTest {

    @Autowired
    private LuckyMoneyService luckyMoneyService;
    @Test
    public void findOneTest() {
        Luckymoney luckymoney = luckyMoneyService.findOne(28);
        Assert.assertEquals(15,luckymoney.getMoney().intValue());
        luckymoney = luckyMoneyService.findOne(77);
        assertEquals(null,luckymoney);
    }
}