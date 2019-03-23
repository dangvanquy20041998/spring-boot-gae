package com.quycntt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.quycntt.entity.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer>{

}
