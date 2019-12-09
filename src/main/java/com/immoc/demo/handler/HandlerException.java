package com.immoc.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mingtu
 * @create 2019/12/7  20:32
 */
@ControllerAdvice
public class HandlerException {
    /*
    * 处理总异常
    * */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest request, Exception ex){
        Map<String,Object> map=new HashMap<>();
        map.put("success",false);
        map.put("errMsg",ex.getMessage());
        return map;
    }
}
