package com.socialnetwork.services.impl;

import com.socialnetwork.domain.Comments;
import com.socialnetwork.repository.CommentRepository;
import com.socialnetwork.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentsService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comments save(Comments comments) {
        return commentRepository.save(comments);
    }

    @Override
    public Comments getAllComment(Comments comments) {
        return null;
    }


}