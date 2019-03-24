package com.quycntt.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.quycntt.demo;
import com.quycntt.entity.Location;
import com.quycntt.serviceimp.LocationServiceImp;

@Controller
public class MainController {
	
	@Autowired
	private LocationServiceImp locationServiceImp;
	
	@Autowired
	private demo demoService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/addLocation")
	@ResponseBody
	public void addLocation(@RequestParam float lat1, @RequestParam float lng1, @RequestParam String location1) {
		Location location = new Location();
		location.setLat_number(lat1);
		location.setLong_number(lng1);
		location.setPosition(location1);
		
		locationServiceImp.saveLocation(location);
	}
	
	@GetMapping("/position/{lat}/{lng}")
	@ResponseBody
	public Location getPosition(@PathVariable(value="lat") String lat, @PathVariable(value="lng") String lng) {
		try {
			Location location = demoService.getLocationInfo(lat, lng);
			locationServiceImp.saveLocation(location);
			return demoService.getLocationInfo(lat, lng);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
