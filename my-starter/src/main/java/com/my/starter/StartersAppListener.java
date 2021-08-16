package com.my.starter;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class StartersAppListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("Сработал листенер");
    }
}
