package com.socialnetwork.services;

import com.socialnetwork.domain.Notification;

import java.util.List;

public interface NotificationService {
    Notification save(Notification notification);

    List<Notification>  findNotificationByUserId(Long id);

}
