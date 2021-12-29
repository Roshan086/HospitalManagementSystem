package com.hospital.management.system.dto;

public class AbstractDTO {
	private String status;
	private String createdDate;
	private String modifiedDate;
	private String createdbBy;
	private String modifiedBy;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedbBy() {
		return createdbBy;
	}

	public void setCreatedbBy(String createdbBy) {
		this.createdbBy = createdbBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
	
}
