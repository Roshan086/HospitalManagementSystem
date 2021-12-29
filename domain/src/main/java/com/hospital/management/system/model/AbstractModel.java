package com.hospital.management.system.model;

import javax.persistence.Column;

public class AbstractModel{
	@Column(name = "status",columnDefinition = "SMALLINT")
	private Boolean status;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
