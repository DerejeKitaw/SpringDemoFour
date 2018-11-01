package com.dkitaw.backend.ui.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dkitaw.backend.service.InstructorDetailService;
import com.dkitaw.backend.service.InstructorService;
import com.dkitaw.backend.shared.dto.InstructorDTO;
import com.dkitaw.backend.ui.model.request.InstructorDetailRequestModel;
import com.dkitaw.backend.ui.model.response.InstructorRest;
import com.dkitaw.backend.ui.model.response.OperationStatusModel;
import com.dkitaw.backend.ui.model.response.RequestOperationName;
import com.dkitaw.backend.ui.model.response.RequestOperationStatus;

@RestController
@RequestMapping("instructor")
public class InstructorController {
	InstructorService instructorService;
	InstructorDetailService instructorDetailService;
	
	public InstructorController(InstructorService instructorService, InstructorDetailService instructorDetailService) {
		this.instructorService = instructorService;
		this.instructorDetailService = instructorDetailService;
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
//	Delete Instructor by instructorId
	@DeleteMapping(path = "/{instructorId}")
	  public OperationStatusModel deleteInstructor(@PathVariable String instructorId) {

	    OperationStatusModel returnValue = new OperationStatusModel();
	    returnValue.setOperationName(RequestOperationName.DELETE.name());

	    // Delete Instructor
	    instructorService.deleteInstructor(instructorId);
	    returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
	    
	    return returnValue;
	  }
	
//	Delete Instructor detail by instructorDetailId
	@DeleteMapping(path = "/detail/{instructorDetailId}")
	  public OperationStatusModel deleteinstructorDetailId(@PathVariable String instructorDetailId) {

	    OperationStatusModel returnValue = new OperationStatusModel();
	    returnValue.setOperationName(RequestOperationName.DELETE.name());

	    // Delete Instructor
	    instructorDetailService.deleteInstructorDetail(instructorDetailId);
	    returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
	    
	    return returnValue;
	  }
	
}
