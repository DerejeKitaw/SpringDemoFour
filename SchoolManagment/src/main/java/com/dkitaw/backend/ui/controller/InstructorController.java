package com.dkitaw.backend.ui.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dkitaw.backend.service.InstructorService;
import com.dkitaw.backend.shared.dto.InstructorDTO;
import com.dkitaw.backend.ui.model.request.InstructorDetailRequestModel;
import com.dkitaw.backend.ui.model.response.InstructorRest;

@RestController
@RequestMapping("instructor")
public class InstructorController {
	InstructorService instructorService;
	
	public InstructorController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}

	@PostMapping(path = "/create")
	  public InstructorRest createInstructor(@RequestBody InstructorDetailRequestModel instructorDetails) throws Exception{

	    InstructorRest returnValue = new InstructorRest();

	    ModelMapper modelMapper = new ModelMapper();
	    InstructorDTO instructorDTO = modelMapper.map(instructorDetails, InstructorDTO.class);

	    InstructorDTO createInstructor = instructorService.createInstructor(instructorDTO);
	    returnValue = modelMapper.map(createInstructor, InstructorRest.class);
	    return returnValue;
	  }
}
