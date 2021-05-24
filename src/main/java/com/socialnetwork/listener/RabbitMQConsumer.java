package com.socialnetwork.listener;

import com.socialnetwork.services.NotificationService;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @Autowired
    NotificationService notificationService;
/*
    @RabbitListener(queues = RabbitMQDirectConfig.QUEUE)
    public void recievedMessage(Notification notification) {
        System.out.println("Recieved Message From RabbitMQ: " + notification.getPost().getText());



//        User user  = post.getUser();
//        List<User> users = user.getFollowing();
//        System.out.println("Following count: " + users.size());
//        users.forEach((u) -> System.out.println("User NAme is :" + u.getUsername()));
    }*/
}
