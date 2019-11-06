package com.zym.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    // produces = "text/plain;charset=UTF-8" 解决请求返回乱码问题
    @RequestMapping(value = "/error", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 401){
            return "401 错误";
        }else if(statusCode == 404){
            return "/404 错误";
        }else if(statusCode == 403){
            return "/403 错误";
        }else{
            return "/500 错误";
        }
    }
}
