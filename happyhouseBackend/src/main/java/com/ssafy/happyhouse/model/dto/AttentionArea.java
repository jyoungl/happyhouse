package com.ssafy.happyhouse.model.dto;

public class AttentionArea {
	private String userId;
	private String sidoName;
	private String gugunName;
	private String dongName;
	
	public AttentionArea() {}

	public AttentionArea(String userId, String sidoName, String gugunName, String dongName) {
		this.userId = userId;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dongName == null) ? 0 : dongName.hashCode());
		result = prime * result + ((gugunName == null) ? 0 : gugunName.hashCode());
		result = prime * result + ((sidoName == null) ? 0 : sidoName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttentionArea other = (AttentionArea) obj;
		if (dongName == null) {
			if (other.dongName != null)
				return false;
		} else if (!dongName.equals(other.dongName))
			return false;
		if (gugunName == null) {
			if (other.gugunName != null)
				return false;
		} else if (!gugunName.equals(other.gugunName))
			return false;
		if (sidoName == null) {
			if (other.sidoName != null)
				return false;
		} else if (!sidoName.equals(other.sidoName))
			return false;
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
		buffer.append(sidoName);
		buffer.append("\t| ");
		buffer.append(gugunName);
		buffer.append("\t| ");
		buffer.append(dongName);
		return buffer.toString();
	}
}
