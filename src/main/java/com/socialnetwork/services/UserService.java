package com.socialnetwork.services;

import com.socialnetwork.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(User user);

    User findUserById(Long id);

    User findUserByName(String name);

    //used in Following Controller to do the follow task
    User rawSave(User user);


    User update(User user);
}
