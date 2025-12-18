package com.wad.firstmvc.notifications;

public interface NotificationSubject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyAll(Notification n);
}