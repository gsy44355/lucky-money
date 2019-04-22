package com.gsy.luckymoney.exception;

import com.gsy.luckymoney.enums.ResultEnum;

public class MoneyException extends RuntimeException {
    private Integer code;

    public MoneyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
