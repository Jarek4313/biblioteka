package com.jdz.biblioteka.service.mapper;

import com.jdz.biblioteka.model.PublishingHouse;
import com.jdz.biblioteka.payload.PublishingHouseDto;
import com.jdz.biblioteka.payload.PublishingHouseResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class PublishingHouseMapper {
    private final BookMapper bookMapper;

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
        if (!CollectionUtils.isEmpty(publishingHouse.getListOfBooks())) {
            publishingHouseDto.setBooksCount(publishingHouse.getListOfBooks().size());
            publishingHouseDto.setListOfBooks(publishingHouse.getListOfBooks()
                    .stream()
                    .map(bookMapper::mapSimple)
                    .toList()
            );
        }

        return publishingHouseDto;
    }

    public PublishingHouseResponse getResponse(List<PublishingHouseDto> content, Page<PublishingHouse> publishingHouses) {
        if (CollectionUtils.isEmpty(content) && Objects.isNull(publishingHouses)) {
            return null;
        }

        PublishingHouseResponse publishingHouse = new PublishingHouseResponse();

        publishingHouse.setContent(content);
        publishingHouse.setPageNumber(publishingHouses.getNumber());
        publishingHouse.setPageSize(publishingHouses.getSize());
        publishingHouse.setTotalElement(publishingHouses.getTotalElements());
        publishingHouse.setTotalPages(publishingHouses.getTotalPages());
        publishingHouse.setLast(publishingHouses.isLast());
        return publishingHouse;
    }
}
