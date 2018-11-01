package com.dkitaw.backend.ui.model.response;

import com.dkitaw.backend.io.entity.InstructorDetailEntity;

public class InstructorRest {
	private String firstName;
	private String lastName;
	private String email;
	private InstructorDetailEntity instructorDetailEntity;
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
	public InstructorDetailEntity getInstructorDetailEntity() {
		return instructorDetailEntity;
	}
	public void setInstructorDetailEntity(InstructorDetailEntity instructorDetailEntity) {
		this.instructorDetailEntity = instructorDetailEntity;
	}
	
	
}
