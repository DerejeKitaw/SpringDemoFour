package com.dkitaw.backend.io.entity.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dkitaw.backend.io.entity.InstructorEntity;

@Repository
public interface InstructorRepository extends PagingAndSortingRepository<InstructorEntity, Integer>{

}
