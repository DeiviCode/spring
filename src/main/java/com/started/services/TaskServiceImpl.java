package com.started.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.started.model.Task;
import com.started.repository.CrudTaskRepository;

@Service
public class TaskServiceImpl implements ITaskService {

	@Autowired
	private CrudTaskRepository crudRepository;
	
	@Override
	public void save(Task task) {
		crudRepository.save(task);
	}

	@Override
	public List<Task> list() {
		return (List<Task>) crudRepository.findAll();
	}

	@Override
	public Task findByTitle(String title) {
		return  crudRepository.findByTitle(title);
	}

	@Override
	public void delete(Task task) {
		crudRepository.delete(task);
		
	}

	@Override
	public Task findById(int id) {
		return  crudRepository.findById(id).get();
	}
}
