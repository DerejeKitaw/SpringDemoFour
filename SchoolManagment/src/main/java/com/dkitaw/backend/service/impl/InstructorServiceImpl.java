package com.dkitaw.backend.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.dkitaw.backend.io.entity.InstructorEntity;
import com.dkitaw.backend.io.entity.repository.InstructorRepository;
import com.dkitaw.backend.service.InstructorService;
import com.dkitaw.backend.shared.dto.InstructorDTO;

@Service
public class InstructorServiceImpl implements InstructorService {

	InstructorRepository instructorRepository;
	
	public InstructorServiceImpl(InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}

	@Override
	public InstructorDTO createInstructor(InstructorDTO instructor) {
		
		ModelMapper modelMapper = new ModelMapper();
		InstructorEntity instructorEntity = modelMapper.map(instructor, InstructorEntity.class);
		
//		instructorEntity.setInstructorId(instructor.getInstructorId());
		
		InstructorEntity storedInstructorDetail = instructorRepository.save(instructorEntity);
		InstructorDTO returnValue = modelMapper.map(storedInstructorDetail, InstructorDTO.class);
	    return returnValue;
	}

	@Override
	public void deleteInstructor(String categoryId) {
		InstructorEntity instructorEntity = instructorRepository.findByInstructorId(categoryId);
		if (instructorEntity == null) {
			try {
				throw new Exception("Not found");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		instructorRepository.delete(instructorEntity);
	}

}
