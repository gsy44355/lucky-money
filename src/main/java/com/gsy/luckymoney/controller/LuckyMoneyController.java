package com.gsy.luckymoney.controller;

import com.gsy.luckymoney.entity.Result;
import com.gsy.luckymoney.repository.LuckyMoneyRepository;
import com.gsy.luckymoney.service.LuckyMoneyService;
import com.gsy.luckymoney.entity.Luckymoney;
import com.gsy.luckymoney.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("luckymoney")
public class LuckyMoneyController {
    @Autowired
    private LuckyMoneyRepository repository;

    /**
     * 获取红包列表
     */
    @GetMapping("/list")
    public List<Luckymoney> list() {
        return repository.findAll();
    }

    /**
     * 创建红包
     */
    @PostMapping("/create")
    public Result create(@Valid Luckymoney luckymoney, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(-1, Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        return ResultUtil.success(repository.save(luckymoney));
    }

    /**
     * 通过ID查询红包
     */
    @GetMapping("/search")
    public Luckymoney findById(@RequestParam("id") String id) {
        return repository.findById(Integer.parseInt(id)).orElse(null);
    }

    /**
     * 更新红包 通过ID
     */
    @PutMapping("/update/{id}")
    public Luckymoney update(@PathVariable("id") Integer id, @RequestParam("consumer") String consumer) {
        Optional<Luckymoney> luckymoney = repository.findById(id);
        if (luckymoney.isPresent()) {
            Luckymoney luckymoney1 = luckymoney.get();
            luckymoney1.setId(id);
            luckymoney1.setConsumer(consumer);
            return repository.save(luckymoney1);
        }
        return null;
    }

    @Autowired
    @Qualifier("luckyMoneyService")
    private LuckyMoneyService luckyMoneyService;

    @PostMapping("/create2")
    public void createTwo() {
        luckyMoneyService.createTwo();
    }

    @GetMapping("/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        luckyMoneyService.getAge(id);
    }
}
