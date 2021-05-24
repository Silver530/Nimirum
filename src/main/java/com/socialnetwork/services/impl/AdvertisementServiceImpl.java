package com.socialnetwork.services.impl;

import com.socialnetwork.domain.Advertisement;
import com.socialnetwork.repository.AdvertisementRepository;
import com.socialnetwork.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    private AdvertisementRepository advertisementRepository;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    public List<Advertisement> getAdList() {
        return advertisementRepository.findAll();
    }

    @Override
    public Advertisement findAdById(Long adId) {
        return advertisementRepository.getOne(adId);
    }

    @Override
    public void save(Advertisement advertisement) {
        advertisementRepository.save(advertisement);
    }
}
