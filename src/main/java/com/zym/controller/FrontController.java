package com.zym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FrontController {

    @RequestMapping("/printData.do")
    // http://127.0.0.1:8100/printData.do
    public @ResponseBody  // 如果不加此注解,return则会加载对应的页面
    String printData() {
        return "hello Springboot";
    }

    /**
     * SpringBoot 视图解析器
     * @return
     */
    @RequestMapping("/home")
    public String toHomePage() {
        return "homePage";
    }

    public static void main(String[] args) {
        System.out.println("Test mvn package");
    }

}
