package com.dkitaw.backend.service.impl;

import org.springframework.stereotype.Service;

import com.dkitaw.backend.io.entity.InstructorDetailEntity;
import com.dkitaw.backend.io.entity.repository.InstructorDetailRepository;
import com.dkitaw.backend.service.InstructorDetailService;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {

	InstructorDetailRepository instructorDetailRepository;
	
	public InstructorDetailServiceImpl(InstructorDetailRepository instructorDetailRepository) {
		this.instructorDetailRepository = instructorDetailRepository;
	}

	@Override
	public void deleteInstructorDetail(String instructorDetailId) {
		InstructorDetailEntity instructorDetailEntity = instructorDetailRepository.findByInstructorDetailId(instructorDetailId);
		if (instructorDetailEntity == null) {
			try {
				throw new Exception("Not found");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Before deleting need to set null to break bi-directional relation
		instructorDetailEntity.getInstructorEntity().setInstructorDetailEntity(null);
		instructorDetailRepository.delete(instructorDetailEntity);
		
	}

	

}
