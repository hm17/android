package com.swegnchic.sampleshoppingcart.danceclasses;

import java.io.Serializable;

public class DanceClass implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private String startTime;
	private int duration;
	private String price;
	private int size;
	private String originalInstructor;
	
	public DanceClass() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getOriginalInstructor() {
		return originalInstructor;
	}
	public void setOriginalInstructor(String originalInstructor) {
		this.originalInstructor = originalInstructor;
	}
}
