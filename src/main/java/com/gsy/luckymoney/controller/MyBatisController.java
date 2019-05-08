package com.gsy.luckymoney.controller;

import com.gsy.luckymoney.entity.Result;
import com.gsy.luckymoney.pojo.UserInfo;
import com.gsy.luckymoney.service.UserService;
import com.gsy.luckymoney.utils.Idworker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("mybatis")
public class MyBatisController {
//    @Autowired
    private UserService userService;
    @Autowired
    private Idworker idworker;
    @GetMapping("/save")
    public Result save() throws  Exception{
        UserInfo userInfo = new UserInfo();
        long id = idworker.getSID();
        userInfo.setId((int) id);
        userInfo.setUsername("abcd"+new Date());
        userInfo.setRealname("12123");
        userInfo.setEmail("44355@qq.com");
        userService.saveUser(userInfo);
        Result result = new Result();
        result.setData(userInfo);
        return  result;
    }
    @GetMapping("update")
    public Object update(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(6);
        userInfo.setRealname("aaaaaaaaaaaaa");
        userInfo.setUsername("uuuuuname");
        userInfo.setPassword("aaaaaaa");
        userService.updateUser(userInfo);
        return userInfo;
    }
    @GetMapping("/list/{page}")
    public Object listByPage(@PathVariable("page") Integer page){
        return userService.list(null,page,10);
    }
    @GetMapping("list_me")
    public Object listByMe(){
        Map map = new HashMap();
        map.put("id","6");
        return  userService.listByMe(map);
    }
}
