package com.wad.firstmvc.notifications;

import java.util.*;

public class NotificationCenter implements NotificationSubject {
    private final List<Observer> observers = new ArrayList<>();
    public void attach(Observer o){ observers.add(o); }
    public void detach(Observer o){ observers.remove(o); }
    public void notifyAll(Notification n){ observers.forEach(o -> o.update(n)); }
}
