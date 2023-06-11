package com.jdz.biblioteka.controller;

import com.jdz.biblioteka.payload.BookDto;
import com.jdz.biblioteka.payload.PublishingHouseDto;
import com.jdz.biblioteka.payload.PublishingHouseResponse;
import com.jdz.biblioteka.service.PublishingHouseService;
import com.jdz.biblioteka.service.impl.PublishingHouseServiceImpl;
import com.jdz.biblioteka.utils.AppConstants;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/publishing-house")
public class PublishingHouseController {
    private final PublishingHouseService publishingHouseService;

    @PostMapping
    public ResponseEntity<PublishingHouseDto> createPublishingHouse(@RequestBody PublishingHouseDto publishingHouseDto) {
        return new ResponseEntity<>(publishingHouseService.createPublishingHouse(publishingHouseDto), HttpStatus.CREATED);
    }

    @GetMapping
    public PublishingHouseResponse getAllBooks(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ) {
        return publishingHouseService.getAllPublishingHouse(pageNo, pageSize, sortBy, sortDir);
    }

}
