package com.jdz.biblioteka.repository;

import com.jdz.biblioteka.model.PublishingHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, Integer> {
    PublishingHouse findPublishingHouseByName(String name);

    @Query("select publishingHouse from PublishingHouse publishingHouse"
        + " left join fetch publishingHouse.listOfBooks")
    Page<PublishingHouse> findAllPublishingHouses(Pageable page);
}
