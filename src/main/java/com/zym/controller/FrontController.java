package com.zym.controller;

import com.zym.service.GetArgumentsBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;


@Controller
public class FrontController {

    @ApiIgnore
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
    @ApiIgnore
    @RequestMapping("/")
    public String toHomePage() {
        return "homePage";
    }

    @ApiIgnore
    @RequestMapping("/args")
    public @ResponseBody
    String getArgs() {
       return new GetArgumentsBean().getArgs();
    }

    public static void main(String[] args) {
        System.out.println("Test mvn package");
    }

}
