package com.socialnetwork.controller;

import com.socialnetwork.domain.Likes;
import com.socialnetwork.domain.Post;
import com.socialnetwork.domain.User;
import com.socialnetwork.services.LikeService;
import com.socialnetwork.services.PostService;
import com.socialnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
public class LikeController {

    @Autowired
    PostService postService;

    @Autowired
    LikeService likeService;

    @Autowired
    UserService userService;

    @PostMapping(value = "/like")
    public Likes addLike(@RequestBody Long id, Principal principal) {
        System.out.println("I am inside addLike method" + id);

        System.out.println(principal.getName());
        User currentUser = userService.findUserByName(principal.getName());

        Post post = postService.findPostById(id);
        Likes likes = new Likes();

        likes.setUser(currentUser);
        likes.addPost(post);
        return likeService.save(likes);

    }


    @DeleteMapping(value = "/like")
    public Likes removeLike(@RequestParam Long likeId, @RequestParam Long postId, Principal principal) {
        System.out.println("I am inside addLike method likeId: " + likeId);
        System.out.println("I am inside addLike method postId: " + postId);
        Likes like = likeService.find(likeId);

        Post post = postService.findPostById(postId);
        post.removeLike(like);

        likeService.remove(like);
        return like;

    }


}
