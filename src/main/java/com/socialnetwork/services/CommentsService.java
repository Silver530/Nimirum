package com.socialnetwork.services;

import com.socialnetwork.domain.Comments;

public interface CommentsService {
    Comments save(Comments comments);

    Comments getAllComment(Comments comments);
}
