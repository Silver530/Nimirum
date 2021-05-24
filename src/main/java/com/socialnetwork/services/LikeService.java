package com.socialnetwork.services;

import com.socialnetwork.domain.Likes;

public interface LikeService  {
    Likes save(Likes likes);

    void remove(Likes likes);

    Likes find(Long id);
}
