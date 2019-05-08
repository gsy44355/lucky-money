package com.gsy.luckymoney.handle;

import com.gsy.luckymoney.entity.Result;
import com.gsy.luckymoney.exception.MoneyException;
import com.gsy.luckymoney.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandle {

//    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof MoneyException){
            return ResultUtil.error(((MoneyException) e).getCode(),e.getMessage());
        }
        return ResultUtil.error(-11,"未知错误");
    }
    @ExceptionHandler(value = MoneyException.class)
    public Object errorHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Exception e){
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception",e);
        modelAndView.addObject("url",httpServletRequest.getRequestURL());
        modelAndView.setViewName("thymeleaf/error");
        return  modelAndView;
    }
}
