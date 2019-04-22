package com.gsy.luckymoney.service;

import com.gsy.luckymoney.entity.Luckymoney;
import org.springframework.transaction.annotation.Transactional;

public interface LuckyMoneyService {
    @Transactional
    void createTwo();

    void getAge(Integer age) throws Exception;

    Luckymoney findOne(Integer id);
}
