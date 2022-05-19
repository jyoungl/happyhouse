package com.ssafy.happyhouse.model.dto;

public class HouseOut {
	private int aptCode;
	private String aptName;
	private String lat;
	private String lng;
	private String dealAmount;
	private int dealDay;
	private String area;
	private String floor;

	public HouseOut() {
	}

	public HouseOut(int aptCode, String aptName, String lat, String lng, String dealAmount, int dealDay, String area, String floor) {
		this.aptCode = aptCode;
		this.aptName = aptName;
		this.lat = lat;
		this.lng = lng;
		this.dealAmount = dealAmount;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
	}

	public int getAptCode() {
		return aptCode;
	}

	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public int getDealDay() {
		return dealDay;
	}

	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return aptCode + " | " + aptName + " | " + lat + " | " + lng + " | " + dealAmount + " | " + dealDay + " | " + area + " | " + floor;
	}

}
