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
* java -jar xxx.jar --server.port=8888命令 等价于application.properties中的server.port配置

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

## Spring 常用注解
编号|注解|说明
---|---|---
1|@Component|[链接](http://syllabus.lianmengtu.top/) 见：三、1.1
2|@Bean|[链接](http://syllabus.lianmengtu.top/) 见：三、1.1
3|@Configuration|[链接](http://syllabus.lianmengtu.top/) 见：三、1.1
4|@Import|[链接](http://syllabus.lianmengtu.top/) 见：三、1.1

## 自定义属性与加载
* com.zym.blog.name=一千零一夜
* com.zym.blog.title=SpringBoot
* 然后通过@Value("${属性名}")
* 详见BlogProperties.java

## log4j2 示例
1. 引入spring-boot-starter-log4j2
2. 在src/main/resources目录下增加: log4j2.xml
3. 示例: http://127.0.0.1:8001/log
4. 代码文件: TextController.java

## 使用随机数
1. 随机数配置见: application.properties
2. 示例: http://127.0.0.1:8001/random

## 禁用CommandLine
* 详见: SpringApplication.setAddCommandLineProperties(false)

# Spring Boot 配置文件
## 一、自动配置
    Spring Boot 提供了对应用进行自动化配置。相比以前 XML 配置方式，很多显式方式申明是不需要的。二者，大多数默认的配置足够实现开发功能，从而更快速开发。
    
    什么是自动配置？
       Spring Boot 提供了默认的配置，如默认的 Bean ，去运行 Spring 应用。它是非侵入式的，只提供一个默认实现。
       大多数情况下，自动配置的 Bean 满足了现有的业务场景，不需要去覆盖。但如果自动配置做的不够好，需要覆盖配置。比如通过命令行动态指定某个 jar ，按不同环境启动（这个例子在第 4 小节介绍）。那怎么办？这里先要考虑到配置的优先级。
       
       Spring Boot 不单单从 application.properties 获取配置，所以我们可以在程序中多种设置配置属性。按照以下列表的优先级排列：
       1.命令行参数
       2.java:comp/env 里的 JNDI 属性
       3.JVM 系统属性
       4.操作系统环境变量
       5.RandomValuePropertySource 属性类生成的 random.* 属性
       6.应用以外的 application.properties（或 yml）文件
       7.打包在应用内的 application.properties（或 yml）文件
       8.在应用 @Configuration 配置类中，用 @PropertySource 注解声明的属性文件
       9.SpringApplication.setDefaultProperties 声明的默认属性
       
       可见，命令行参数优先级最高。这个可以根据这个优先级，可以在测试或生产环境中快速地修改配置参数值，而不需要重新打包和部署应用。
       还有第 6 点，根据这个在多 moudle 的项目中，比如常见的项目分 api 、service、dao 等 moudles，往往会加一个 deploy moudle 去打包该业务各个子 moudle，应用以外的配置优先。
   
## @ConfigurationProperties属性
1. 增加dependency
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```
2. 创建一个用于@ConfigurationProperties的类，例如：MysqlProperties.java
3. 该类要实现Getter和Setter

# Spring Boot Web 开发
## RESTful API以及单元测试
* 一个很好的http各种请求类型示例

详见：
1. 实现类：UserController.java
2. 测试类：UserControllerTest.java

请求类型|URL|功能说明
---|---|---
GET|/users|查询用户列表
POST|/users|创建一个用户
GET|/users/id|根据id查询一个用户
PUT|/users/id|根据id更新一个用户
DELETE|/users/id|根据id删除一个用户

## Springboot 实现 Restful 服务，基于 HTTP / JSON 传输

* (1) pom中增加数据库依赖
```xml
<dependencies>
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.3.2</version>
    </dependency>
    
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.12</version>
    </dependency>
</dependencies>

```

* (2) application-dev.properties文件增加相关配置
```text
## 数据源配置
spring.datasource.url=jdbc:mysql://localhost:3306/springbootdb?useUnicode=true&characterEncoding=utf8
spring.datasource.username=springboot
spring.datasource.password=qwer1234
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

## Mybatis 配置
mybatis.typeAliasesPackage=org.zym.beans
mybatis.mapperLocations=classpath:mapper/*.xml
```
* (3) 增加mapper文件
```text
resources/mapper/CityMapper.xml
```

* (4) 增加一个city bean
```
com.zym.beans.City.java
```

* (5) 增加一个Dao层接口
```text
com.zym.dao.CityDao.java
```

* (6) 增加一个Service层接口 和 对应的实现类
```text
com.zym.service.CityService.java
com.zym.service.impl.CityServiceImpl.java
```
* (6) 在MainApplication中增加mapper扫描注解
```text
// mapper 接口类扫描包配置
@MapperScan("com.zym.dao")
```

