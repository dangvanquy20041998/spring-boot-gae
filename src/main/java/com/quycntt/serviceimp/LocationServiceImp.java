package com.quycntt.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quycntt.entity.Location;
import com.quycntt.repository.LocationRepository;
import com.quycntt.service.LocationService;

@Service
public class LocationServiceImp implements LocationService{
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void saveLocation(Location location) {
		locationRepository.save(location);
	}
}
