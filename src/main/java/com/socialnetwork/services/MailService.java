package com.socialnetwork.services;

import com.socialnetwork.domain.User;

public interface MailService {

    void sendEmail(User user, String subject, String body);

}
