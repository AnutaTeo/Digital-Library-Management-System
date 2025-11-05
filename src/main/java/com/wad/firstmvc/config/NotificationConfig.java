package com.wad.firstmvc.config;

import com.wad.firstmvc.notifications.DefaultNotificationFactory;
import com.wad.firstmvc.notifications.EmailNotifier;
import com.wad.firstmvc.notifications.NotificationCenter;
import com.wad.firstmvc.notifications.NotificationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
    @Bean
    NotificationFactory notificationFactory(){ return new DefaultNotificationFactory(); }
    @Bean
    NotificationCenter notificationCenter(){
        var c = new NotificationCenter();
        c.attach(new EmailNotifier());
        return c;
    }
}