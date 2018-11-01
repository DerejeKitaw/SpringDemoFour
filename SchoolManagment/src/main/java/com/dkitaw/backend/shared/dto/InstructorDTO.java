package com.dkitaw.backend.shared.dto;

import java.io.Serializable;

import com.dkitaw.backend.io.entity.InstructorDetailEntity;

public class InstructorDTO implements Serializable {
	private static final long serialVersionUID = 382871879533969397L;
	private int id;
	private String instructorId;
	private String firstName;
	private String lastName;
	private String email;
	private InstructorDetailEntity instructorDetailEntity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
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
	public InstructorDetailEntity getInstructorDetailEntity() {
		return instructorDetailEntity;
	}
	public void setInstructorDetailEntity(InstructorDetailEntity instructorDetailEntity) {
		this.instructorDetailEntity = instructorDetailEntity;
	}
	

}
