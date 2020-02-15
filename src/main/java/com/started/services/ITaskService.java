package com.started.services;

import java.util.List;

import com.started.model.Task;

public interface ITaskService {
	
	public void save(Task task);
	public List<Task> list();
	public Task findByTitle(String title);
	public Task findById(int id);
	public void delete(Task task);
}
