package com.ssafy.happyhouse.model.dto;

public class User {
	private String userid;
	private String userpwd;
	private String name;
	private String email;
	private String phone;
	private String dongCode;
	private String jibun;
	
	public User() {}
	public User(String userid, String password, String name, String email, String phone, String dongCode, String jibun) {
		this.userid = userid;
		this.userpwd = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dongCode = dongCode;
		this.jibun = jibun;
	}
	
	
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String password) {
		this.userpwd = password;
	}
	public String getUsername() {
		return name;
	}
	public void setUsername(String name) {
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
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(userid);
		buffer.append("\t| ");
		buffer.append(userpwd);
		buffer.append("\t| ");
		buffer.append(name);
		buffer.append("\t| ");
		buffer.append(email);
		buffer.append("\t| ");
		buffer.append(phone);
		return buffer.toString();
	}
}
