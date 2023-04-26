package com.cg.service;

import java.util.List;

import com.cg.entity.Task;

public interface TaskService {
	
	Task addtask(Task taskname);
	Task updatetaskdetails ( Task taskname);
	String deletebyid (int tid);
	Task showtaskdetailsbyid(int tid);
	List<Task> showAllTasks();

}
