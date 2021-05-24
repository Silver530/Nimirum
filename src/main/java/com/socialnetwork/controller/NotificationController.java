package com.socialnetwork.controller;

import com.socialnetwork.domain.Notification;
import com.socialnetwork.domain.Post;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {
    @MessageMapping("/hello")
    @SendTo("/topic/notification")
    public Notification notification(Post post) throws Exception {
        System.out.println("NOTIFICATION received on SERVER" + post.getText());
         Notification notify = new Notification();
         notify.setPost(post);
//         notify.setUser(post.getUser());
         return notify;
    }
}
