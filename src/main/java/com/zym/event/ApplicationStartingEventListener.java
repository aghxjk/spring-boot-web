package com.zym.event;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.err.println("在运行开始，但除了监听器注册和初始化以外的任何处理之前，会触发一个ApplicationStartingEvent");
    }
}
