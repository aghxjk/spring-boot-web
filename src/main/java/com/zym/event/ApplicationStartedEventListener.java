package com.zym.event;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.err.println("在context被刷新之后，但是在任何应用程序和命令行运行者被调用之前，会出发ApplicationStartedEvent");
    }
}
