package com.hospital.management.system.dto;

import io.swagger.annotations.ApiModelProperty;

public class AbstractDTO {
	@ApiModelProperty(value="statuc",notes = "The database generated statuc",hidden = true)
	private String status;
	@ApiModelProperty(value="createdDate",notes = "The database generated createdDate",hidden = true)
	private String createdDate;
	@ApiModelProperty(value="modifiedDate",notes = "The database generated modifiedDate",hidden = true)
	private String modifiedDate;
	@ApiModelProperty(value="createdBy",notes = "The database generated createdBy",hidden = true)
	private String createdBy;
	@ApiModelProperty(value="modifiedBy",notes = "The database generated modifiedBy",hidden = true)
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
	
}
