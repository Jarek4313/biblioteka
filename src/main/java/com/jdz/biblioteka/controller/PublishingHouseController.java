package com.jdz.biblioteka.controller;

import com.jdz.biblioteka.payload.BookDto;
import com.jdz.biblioteka.payload.PublishingHouseDto;
import com.jdz.biblioteka.service.PublishingHouseService;
import com.jdz.biblioteka.service.impl.PublishingHouseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/publishing-house")
public class PublishingHouseController {
    private final PublishingHouseService publishingHouseService;

    @PostMapping
    public ResponseEntity<PublishingHouseDto> createBook(@RequestBody PublishingHouseDto publishingHouseDto) {
        return new ResponseEntity<>(publishingHouseService.createPublishingHouse(publishingHouseDto), HttpStatus.CREATED);
    }
}
