package com.socialnetwork.services;


import org.springframework.web.multipart.MultipartFile;


public interface ProfileImageUploadService {

    String uploadImage(MultipartFile file);
}
