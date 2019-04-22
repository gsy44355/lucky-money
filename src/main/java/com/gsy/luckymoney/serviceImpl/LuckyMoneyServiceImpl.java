package com.gsy.luckymoney.serviceImpl;

import com.gsy.luckymoney.enums.ResultEnum;
import com.gsy.luckymoney.exception.MoneyException;
import com.gsy.luckymoney.repository.LuckyMoneyRepository;
import com.gsy.luckymoney.entity.Luckymoney;
import com.gsy.luckymoney.service.LuckyMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service("luckyMoneyService")
@Scope(value = "singleton")
public class LuckyMoneyServiceImpl implements LuckyMoneyService {
    @Autowired
    private LuckyMoneyRepository luckyMoneyRepository;
    @Override
    public void createTwo() {
        try{
            Luckymoney luckymoney1 = new Luckymoney();
            luckymoney1.setProducer("中文");
            luckymoney1.setMoney(new BigDecimal(520));

            luckyMoneyRepository.save(luckymoney1); Luckymoney luckymoney2 = new Luckymoney();
            luckymoney2.setProducer("中文");
            luckymoney2.setMoney(new BigDecimal(13141));
            luckyMoneyRepository.save(luckymoney2);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void getAge(Integer id) throws Exception {
        Luckymoney luckymoney = luckyMoneyRepository.findById(id).get();
        BigDecimal money = luckymoney.getMoney();
        if(money.compareTo(BigDecimal.valueOf(100)) == -1){
            throw new MoneyException(ResultEnum.TOO_LITTLE);
        }
    }

    /**
     * 查询并返回
     * @param id
     * @return
     */
    @Override
    public  Luckymoney findOne(Integer id){
        return luckyMoneyRepository.findById(id).orElse(null);
    }
}
