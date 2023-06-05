package com.jdz.biblioteka.repository;

import com.jdz.biblioteka.model.PublishingHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, Integer> {
    PublishingHouse findPublishingHouseByName(String name);
}
