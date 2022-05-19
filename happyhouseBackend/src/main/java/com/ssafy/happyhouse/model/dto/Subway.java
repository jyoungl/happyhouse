package com.ssafy.happyhouse.model.dto;

public class Subway {
	
	private int no;
	private String line;
	private String subwayName;
	private String address;
	private String dongName;
	private double lat;
	private double lng;
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public Subway() {}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getSubwayName() {
		return subwayName;
	}

	public void setSubwayName(String subwayName) {
		this.subwayName = subwayName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
