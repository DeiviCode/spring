package com.started.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.started.model.Task;

@Repository
public interface CrudTaskRepository extends CrudRepository<Task, Integer> {
	
	public Task findByTitle (String title);
}
