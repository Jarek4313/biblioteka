package com.jdz.biblioteka.service.mapper;

import com.jdz.biblioteka.model.PublishingHouse;
import com.jdz.biblioteka.payload.PublishingHouseDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PublishingHouseMapper {

    public PublishingHouse map(PublishingHouseDto publishingHouseDto) {
        if (Objects.isNull(publishingHouseDto)) {
            return null;
        }

        PublishingHouse publishingHouse = new PublishingHouse();

        publishingHouse.setName(publishingHouseDto.getName());

        return publishingHouse;
    }

    public PublishingHouseDto map(PublishingHouse publishingHouse) {
        if (Objects.isNull(publishingHouse)) {
            return null;
        }

        PublishingHouseDto publishingHouseDto = new PublishingHouseDto();

        publishingHouseDto.setName(publishingHouse.getName());

        return publishingHouseDto;
    }
}
