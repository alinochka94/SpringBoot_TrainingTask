package com.avioApplication.repository;

import com.avioApplication.entity.CitiesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends CrudRepository<CitiesEntity, Long> {

}