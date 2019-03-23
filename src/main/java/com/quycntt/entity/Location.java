package com.quycntt.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private float lat_number;
	
	@Column
	private float long_number;
	
	@Column
	private String position;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getLat_number() {
		return lat_number;
	}

	public void setLat_number(float lat_number) {
		this.lat_number = lat_number;
	}

	public float getLong_number() {
		return long_number;
	}

	public void setLong_number(float long_number) {
		this.long_number = long_number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
