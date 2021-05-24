package com.socialnetwork.services.impl;

import com.socialnetwork.repository.LikeRepository;
import com.socialnetwork.domain.Likes;
import com.socialnetwork.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Override
    public Likes save(Likes likes) {
        return likeRepository.save(likes);
    }

    @Override
    public void remove(Likes likes) {
        likeRepository.delete(likes);
    }

    @Override
    public Likes find(Long id) {
        return likeRepository.getOne(id);
    }

}