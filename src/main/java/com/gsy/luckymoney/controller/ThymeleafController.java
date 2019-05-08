package com.gsy.luckymoney.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("th")
public class ThymeleafController {
    @GetMapping("/index")
    public String index(){
        return "thymeleaf/index";
    }
    @GetMapping("index1")
    public String index1(ModelMap modelMap){
        modelMap.addAttribute("name","这个是map");
        return "thymeleaf/center/index";
    }
}
