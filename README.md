# SpringBoot 学习示例

## 参考网站
[Spring Boot 2.x](http://syllabus.lianmengtu.top/)

[Spring Boot文档](http://springboot.lianmengtu.top/)

## 环境-配置文件-启用
* 参考application.properties文件中的: spring.profiles.active=dev

## 测试地址
* http://127.0.0.1:8001/
* http://127.0.0.1:8001/home
* http://127.0.0.1:8001/printData.do
* 

## 打包 & 运行
* mvn package 
* java -jar target/demo-0.0.1.jar --debug

## 自定义banner
1. 在resources目录下,创建banner.txt文件
2. 在application.properties或application-dev.properties中配置:
* spring.banner.location=classpath:banner.txt

## SpringBoot：事件
* SpringApplication启动过程会触发的6个事件，具体解释见com.zym.event包下的事件监听器
1. ApplicationStartingEvent
2. ApplicationEnvironmentPreparedEvent
3. ApplicationPreparedEvent
4. ApplicationStartedEvent
5. ApplicationReadyEvent

## SpringBoot：获取启动参数
* 通过注入一个ApplicationArguments类型的bean，获取传递的应用参数
1. 详见GetArgumentsBean类;
2. arguments为static变量;

## CommandLineRunner 和 ApplicationRunner
* 服务启动过程可以用于加载数据

# Spring 常用注解
编号|注解|说明
---|---|---
1|@Component|[链接](http://syllabus.lianmengtu.top/) 见：三、1.1
2|@Bean|[链接](http://syllabus.lianmengtu.top/) 见：三、1.1
3|@Configuration|[链接](http://syllabus.lianmengtu.top/) 见：三、1.1
4|@Import|[链接](http://syllabus.lianmengtu.top/) 见：三、1.1


