package com.socialnetwork.controller;

import com.socialnetwork.domain.Notification;
import com.socialnetwork.domain.Post;
import com.socialnetwork.domain.Profile;
import com.socialnetwork.domain.User;
import com.socialnetwork.services.*;
import com.socialnetwork.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @Autowired
    ProfileService profileService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    AdvertisementService advertisementService;


    @ModelAttribute("currentUser")
    public Profile currentUser(Principal principal){
        User user = userService.findUserByName(principal.getName());
        return user.getProfile();
    }

    @GetMapping("/")
    public String post(@ModelAttribute("addPost") Post post, Model model, Principal principal) {
        Page<Post> posts = postService.allFollowingsPostsPaged(currentUser(principal).getId(),0);
        if(posts.isEmpty()){
            model.addAttribute("nextPage", -1);
        }else if(posts.getContent().size()<5){
            model.addAttribute("nextPage",0);
        }else{
            model.addAttribute("nextPage", 1);
        }

        model.addAttribute("allPost", posts);

        List<Profile> suggestions = profileService.findTop5(currentUser(principal).getId());
        model.addAttribute("suggestions", suggestions);

        User user = userService.findUserByName(principal.getName());
        List<Notification> notifications = notificationService.findNotificationByUserId(user.getId());
        System.out.println("All Notifications"+ notifications.size());
        model.addAttribute("notifications", notifications);


        model.addAttribute("ads", advertisementService.getAdList());

        return "index";
    }

    @GetMapping("/{pageNo}")
    public @ResponseBody Page<Post> getPostsPaged(@PathVariable("pageNo") Integer pageNo){
        System.out.println("-------------getPostPaged Called=---------------------");
        Page<Post> posts = postService.allPostsPaged(pageNo);
        return posts;
    }








//
//    @GetMapping("/error")
//    public String showErrorPage(){
//        return "error";
//    }

    @GetMapping("/index")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/denied")
    public String denied(){
        return "denied";
    }
}
