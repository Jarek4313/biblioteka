package com.jdz.biblioteka.service;


import com.jdz.biblioteka.payload.PublishingHouseDto;
import com.jdz.biblioteka.payload.PublishingHouseResponse;
import org.springframework.http.ResponseEntity;

public interface PublishingHouseService {
    PublishingHouseDto createPublishingHouse(PublishingHouseDto publishingHouseDto);

    PublishingHouseResponse getAllPublishingHouse(int pageNo, int pageSize, String sortBy, String sortDir);
}
