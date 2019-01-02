package com.zym.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 1. @RestController
 *    此注解也是SpringBoot的一个组合注解，它相当于: @ResponseBody ＋ @Controller
 *    这意味着Spring MVC可以使用它来处理Web请求.
 */
@RestController
public class TextController {

    /*
     * 从浏览器调用或在命令行上使用curl时，该方法返回纯文本。
     * 这是因为:
     *     标签@RestController组合@Controller和@ResponseBody
     *     两个注释会导致Web请求返回数据而不是视图。
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "pure text response111";
    }
}
