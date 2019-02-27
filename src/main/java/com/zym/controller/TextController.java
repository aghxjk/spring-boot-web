package com.zym.controller;
import com.zym.beans.BlogProperties;
import com.zym.beans.MysqlProperties;
import com.zym.beans.RandomProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 1. @RestController
 *    此注解也是SpringBoot的一个组合注解，它相当于: @ResponseBody ＋ @Controller
 *    这意味着Spring MVC可以使用它来处理Web请求.
 */
@RestController
public class TextController {

    private static Logger logger = LogManager.getLogger(TextController.class);
    /*
     * 从浏览器调用或在命令行上使用curl时，该方法返回纯文本。
     * 这是因为:
     *     标签@RestController组合@Controller和@ResponseBody
     *     两个注释会导致Web请求返回数据而不是视图。
     * @return
     */
    @Autowired
    BlogProperties blogProperties;

    @Autowired
    RandomProperties randomProperties;

    @Autowired
    MysqlProperties mysqlProperties;

    @ApiIgnore
    @RequestMapping("/")
    public String index() {
        return "pure text response111";
    }

    @ApiIgnore
    @RequestMapping("/log")
    public String log4jTest() {
//        System.out.println(blogProperties.getName());
        logger.debug(blogProperties.getName());
        logger.info(blogProperties.getTitle());
        logger.warn(blogProperties.getDescription());
        logger.error(blogProperties.getClass());
        logger.fatal("Damn Fatal error. Please fix me.");
        return "logf4 test: " + blogProperties.getDescription();
    }

    @ApiIgnore
    @RequestMapping("/random")
    public String randomConfigTest() {
//        logger.info(randomProperties.getRandomStr());
//        logger.info(randomProperties.getRandomInt());
//        logger.info(randomProperties.getRandLong());
//        logger.info(randomProperties.getRandRange1());
//        logger.info(randomProperties.getRandRange2());
        System.out.println(System.getProperty("user.name"));
        return "randomStr = " + randomProperties.getRandomStr() + "<br>" +
                "randomInt = " + randomProperties.getRandomInt() + "<br>" +
                "randomLong = " + randomProperties.getRandLong() + "<br>" +
                "randomRange < 10 : " + randomProperties.getRandRange1() + "<br>" +
                "10 < randomRange < 20 :" + randomProperties.getRandRange2();
    }

    @ApiIgnore
    @RequestMapping("/cfp")
    public String autoConfigPropertiesTest() {
        return mysqlProperties.toString();
    }
}
