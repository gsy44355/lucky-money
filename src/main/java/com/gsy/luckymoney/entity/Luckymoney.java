package com.gsy.luckymoney.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

@Entity
public class Luckymoney {
    @Id
    @GeneratedValue
    private Integer id;
    @DecimalMin(value = "10",message = "不能比我设置的还小")
    public BigDecimal money;
    /**
     * 发送方
     */
    private  String producer;
    /**
     * 接收方
     */
    private  String consumer;

    public Luckymoney() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    @Override
    public String toString() {
        return "Luckymoney{" +
                "id=" + id +
                ", money=" + money +
                ", producer='" + producer + '\'' +
                ", consumer='" + consumer + '\'' +
                '}';
    }
}
