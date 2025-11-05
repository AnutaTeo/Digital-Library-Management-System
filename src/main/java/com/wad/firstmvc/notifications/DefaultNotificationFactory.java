package com.wad.firstmvc.notifications;

import com.wad.firstmvc.domain.circulation.Loan;

public class DefaultNotificationFactory implements NotificationFactory {
    public Notification create(String type, Object payload){
        return switch (type) {
            case "DUE_SOON" -> new DueSoonNotification((Loan) payload);
            default -> throw new IllegalArgumentException("unknown type: " + type);
        };
    }
}