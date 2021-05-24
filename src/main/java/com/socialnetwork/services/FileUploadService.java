package com.socialnetwork.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    String saveImage(MultipartFile file) throws Exception;
}