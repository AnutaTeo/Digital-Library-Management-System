package com.wad.firstmvc.notifications;

public interface NotificationFactory {
    Notification create(String type, Object payload);
}