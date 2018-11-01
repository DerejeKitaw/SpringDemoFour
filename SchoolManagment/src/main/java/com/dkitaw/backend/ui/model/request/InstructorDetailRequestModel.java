package com.dkitaw.backend.ui.model.request;

import com.dkitaw.backend.io.entity.InstructorDetailEntity;

public class InstructorDetailRequestModel {
	private String  instructorId;
	private String firstName;
	private String lastName;
	private String email;
	private InstructorDetailEntity instructorDetailEntity;
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	public InstructorDetailEntity getInstructorDetailEntity() {
		return instructorDetailEntity;
	}
	public void setInstructorDetailEntity(InstructorDetailEntity instructorDetailEntity) {
		this.instructorDetailEntity = instructorDetailEntity;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
