package com.gsy.luckymoney.aspect;

import com.gsy.luckymoney.entity.Result;
import com.gsy.luckymoney.enums.ResultEnum;
import com.gsy.luckymoney.utils.ResultUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.omg.IOP.ServiceContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Aspect
@Component//引入
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.gsy.luckymoney.controller.MyBatisController.*(..))")
    public void  log(){
    }
    @Before("log()")
    public  void logBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //class method
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("params={}",joinPoint.getArgs());
    }
    @AfterReturning(pointcut = "log()",returning = "object")
    public void afterLog(Object object){
        logger.info("response={}",object);
        Result result = new Result();
        object = ResultUtil.success(object);
    }
    @After(value = "log()")
    public void after(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();

    }
}
