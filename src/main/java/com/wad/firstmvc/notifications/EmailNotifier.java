package com.wad.firstmvc.notifications;

public class EmailNotifier implements Observer {
    public void update(Notification n){
        System.out.println("[EMAIL] " + n.render());
    }
}