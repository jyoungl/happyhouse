package com.ssafy.happyhouse.model.dto;

public class User {
	private String userId;
	private String password;
	private String name;
	private String email;
	private String phone;
	
	public User() {}
	public User(String userId, String password, String name, String email, String phone) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(userId);
		buffer.append("\t| ");
		buffer.append(password);
		buffer.append("\t| ");
		buffer.append(name);
		buffer.append("\t| ");
		buffer.append(email);
		buffer.append("\t| ");
		buffer.append(phone);
		return buffer.toString();
	}
}
