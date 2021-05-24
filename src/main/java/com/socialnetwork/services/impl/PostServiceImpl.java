package com.socialnetwork.services.impl;

import com.socialnetwork.domain.Notification;
import com.socialnetwork.domain.Post;
import com.socialnetwork.domain.User;
import com.socialnetwork.repository.PostRepository;
import com.socialnetwork.services.NotificationService;
import com.socialnetwork.services.PostService;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    NotificationService notificationService;
/*
    @Autowired
    private RabbitTemplate rabbitTemplate;
*/
//    public PostController(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }

    public Post save(Post post) {

        // rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, order);
        if(post.isNotifyAllFollowers()){
            User user  = post.getUser();
            List<User> users = user.getFollowing();
            System.out.println("Following count: " + users.size());
            users.forEach((u) -> {
                System.out.println("User NAme is :" + u.getUsername());
                Notification notification = new Notification();
                notification.setPost(post);
                notification.setUser(u);
                notificationService.save(notification);
             //   rabbitTemplate.convertAndSend(RabbitMQDirectConfig.EXCHANGE, RabbitMQDirectConfig.ROUTING_KEY, notification);
            });



        }

        return postRepository.save(post);
    }

    public List<Post> findPost() {
        return postRepository.findByEnabledOrderByCreationDateDesc(true);
    }

    public Post findPostById(Long id) {
        return postRepository.getOne(id);
    }

    @Override
    public List<Post> findAllPostForSpecificUser(Long id) {
       return postRepository.findAllPostForSpecificUser(id);
    }

    @Override
    public Page<Post> allPostsPaged(int pageNo){
        return postRepository.findAll(PageRequest.of(pageNo, 5, Sort.by("creationDate").descending()));
    }

    @Override
    public List<Post> searchPosts(String text){
        return postRepository.findPostsByTextContaining(text);
    }

    @Override
    public Page<Post> allFollowingsPostsPaged(Long userId, int pageNo){
//        return postRepository.findAll(PageRequest.of(pageNo, 5, Sort.by("creationDate").descending()));
        return postRepository.getAllPostsFromFollowingPaged2(userId ,PageRequest.of(pageNo, 5, Sort.by("creationDate").descending()));
    }

}
