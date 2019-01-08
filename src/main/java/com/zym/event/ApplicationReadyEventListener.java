package com.zym.event;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.err.println("在任何应用程序和命令行运行程序被调用之后，都会触发一个ApplicationReadyEvent。它表明应用程序已经准备好服务请求");
    }
}
