package com.gsy.luckymoney.repository;

import com.gsy.luckymoney.entity.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckyMoneyRepository extends JpaRepository<Luckymoney,Integer> {
}
