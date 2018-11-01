package com.dkitaw.backend.io.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class CourseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private InstructorEntity instructorEntiry;
	
	public CourseEntity() {
		
	}

	public CourseEntity(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public InstructorEntity getInstructor() {
		return instructorEntiry;
	}

	public void setInstructor(InstructorEntity instructorEntiry) {
		this.instructorEntiry = instructorEntiry;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
}



