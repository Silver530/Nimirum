package com.socialnetwork.services;

import com.socialnetwork.domain.Advertisement;

import java.util.List;

public interface AdvertisementService {
    List<Advertisement> getAdList();

    Advertisement findAdById(Long adId);

    void save(Advertisement advertisement);
}
