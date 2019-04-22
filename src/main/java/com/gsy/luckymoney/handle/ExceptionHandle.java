package com.gsy.luckymoney.handle;

import com.gsy.luckymoney.entity.Result;
import com.gsy.luckymoney.exception.MoneyException;
import com.gsy.luckymoney.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof MoneyException){
            return ResultUtil.error(((MoneyException) e).getCode(),e.getMessage());
        }
        return ResultUtil.error(-11,"未知错误");
    }
}
