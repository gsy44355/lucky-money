package com.gsy.luckymoney.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;

@Service
@Scope(value = "singleton")
public class Idworker {
    public static long sidNum = new Date().getTime();
    public synchronized long getSID(){
        sidNum++;
        return (sidNum);
    }
}
