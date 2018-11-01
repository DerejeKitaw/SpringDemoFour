package com.dkitaw.backend.io.entity.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dkitaw.backend.io.entity.InstructorDetailEntity;

@Repository
public interface InstructorDetailRepository extends PagingAndSortingRepository<InstructorDetailEntity, Integer>{

	InstructorDetailEntity findByInstructorDetailId(String instructorDetailId);

	
}
