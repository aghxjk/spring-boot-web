package com.zym;

import com.zym.event.*;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. @SpringBootApplication
 *    这个注解是SpringBoot的一个组合注解，用于组合以前的Spring项目的如下3个注解.
 *       a) @Configuration
 *       b) @EnableAutoConfiguration
 *       c) @ComponentScan
 *
 *    即： @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
 *
 * 注解说明：
 * 1. @Configuration的注解类标识这个类可以使用Spring IoC容器作为bean定义的来源;@Bean注解告诉Spring，一个带有@Bean的注解方法将返回一个对象，该对象应该被注册为在Spring应用程序上下文中的bean。
 * 2. @EnableAutoConfiguration：能够自动配置spring的上下文，试图猜测和配置你想要的bean类，通常会自动根据你的类路径和你的bean定义自动配置。
 * 3. @ComponentScan：会自动扫描指定包下的全部标有@Component的类，并注册成bean，当然包括@Component下的子注解@Service,@Repository,@Controller。
 * ---------------------
 */
//@SpringBootApplication(scanBasePackages = {"com.zym.controller","com.zym.service"})
@SpringBootApplication
public class MainApplication {

    /**
     * springboot 启动入口
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 1. SpringApplication是springboot框架的核心类
         * 2. SpringMVC核心类是：DispatcherServlet
         * 3. Spring核心类是：ClassPathXmlApplicationContext
         * 4. Mybatis核心类是：SqlSession
         */
//        SpringApplication.run(RunApplication.class, args);
        SpringApplication app = new SpringApplication(MainApplication.class);
        /**
         * 创建SpringBoot的6个监听器
         */
        app.addListeners(new ApplicationStartingEventListener());
        app.addListeners(new ApplicationEnvironmentPreparedEventListener());
        app.addListeners(new ApplicationPreparedEventListener());
        app.addListeners(new ApplicationStartedEventListener());
        app.addListeners(new ApplicationReadyEventListener());
        app.addListeners(new ApplicationFailedEventListener());
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.run(args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//        };
//    }
}
