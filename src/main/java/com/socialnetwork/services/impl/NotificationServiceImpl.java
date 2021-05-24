package com.socialnetwork.services.impl;

import com.socialnetwork.domain.Notification;
import com.socialnetwork.repository.NotificationRepository;
import com.socialnetwork.services.NotificationService;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;
/*
    @Autowired
    private RabbitTemplate rabbitTemplate;
*/

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findNotificationByUserId(Long id) {
        return notificationRepository.findAllByUser_Id(id);

    }
}
