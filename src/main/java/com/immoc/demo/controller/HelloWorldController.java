package com.immoc.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mingtu
 * @create 2019/12/7  16:18
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/helloWorld")
    public String helloWorld(){
        System.out.println("springBoot测试");
        return " Hello springBoot";
    }

}
