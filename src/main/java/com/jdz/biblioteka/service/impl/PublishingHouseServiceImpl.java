package com.jdz.biblioteka.service.impl;

import com.jdz.biblioteka.model.PublishingHouse;
import com.jdz.biblioteka.payload.PublishingHouseDto;
import com.jdz.biblioteka.payload.PublishingHouseResponse;
import com.jdz.biblioteka.repository.PublishingHouseRepository;
import com.jdz.biblioteka.service.PublishingHouseService;
import com.jdz.biblioteka.service.mapper.PublishingHouseMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PublishingHouseResponse getAllPublishingHouse(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
            Sort.by(sortBy).ascending() :
            Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<PublishingHouse> publishingHouses = publishingHouseRepository.findAllPublishingHouses(pageable);

        List<PublishingHouse> listOfPublishingHouse = publishingHouses.getContent();
        List<PublishingHouseDto> content = listOfPublishingHouse.stream()
                .map(publishingHouseMapper::map)
                .toList();

        return publishingHouseMapper.getResponse(content, publishingHouses);
    }
}
