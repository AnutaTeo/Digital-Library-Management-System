package com.dlms.notificationservice.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "${library.mq.queue}")
    public void handleBorrowCreated(String message) {
        System.out.println("Notification received: " + message);
    }
}
