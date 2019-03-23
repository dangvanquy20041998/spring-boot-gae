package com.quycntt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quycntt.entity.Location;
import com.quycntt.serviceimp.LocationServiceImp;

@Controller
public class MainController {
	
	@Autowired
	private LocationServiceImp locationServiceImp;
	
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
}
