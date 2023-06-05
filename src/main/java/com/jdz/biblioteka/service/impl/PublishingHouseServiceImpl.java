package com.jdz.biblioteka.service.impl;

import com.jdz.biblioteka.model.PublishingHouse;
import com.jdz.biblioteka.payload.PublishingHouseDto;
import com.jdz.biblioteka.repository.PublishingHouseRepository;
import com.jdz.biblioteka.service.PublishingHouseService;
import com.jdz.biblioteka.service.mapper.PublishingHouseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PublishingHouseServiceImpl implements PublishingHouseService {
    private final PublishingHouseRepository publishingHouseRepository;

    private final PublishingHouseMapper publishingHouseMapper;

    @Override
    public PublishingHouseDto createPublishingHouse(PublishingHouseDto publishingHouseDto) {
        PublishingHouse publishingHouse = publishingHouseMapper.map(publishingHouseDto);

        PublishingHouse newPublishingHouse = publishingHouseRepository.save(publishingHouse);

        return publishingHouseMapper.map(newPublishingHouse);
    }
}
