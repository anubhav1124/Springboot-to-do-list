package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Task;
import com.cg.excpetions.TaskDetailsNotFoundException;
import com.cg.excpetions.TaskIdNotFoundException;
import com.cg.repository.TaskRepository;

@Service
public class TaskServiceImplement implements TaskService {

	@Autowired
	public TaskRepository taskrepository;

	

	@Override
	public Task addtask(Task tasks) {

		return taskrepository.saveAndFlush(tasks);
	}

	@Override
	public Task updatetaskdetails( Task task) {

		if (!taskrepository.existsById(task.getTid())) {
			throw new TaskIdNotFoundException("Task details not found ");
		}

		else

		{
			Task tasks = taskrepository.findById(task.getTid()).get();
			tasks.setTaskName(tasks.getTaskName());
			tasks.setTaskStatus(tasks.getTaskStatus());

			taskrepository.save(tasks);

			return tasks;

		}

	}

	@Override
	public String deletebyid(int tid) {

		if (taskrepository.existsById(tid)) {
			taskrepository.deleteById(tid);
			return "Task Details have been sucessfully deleted by id";
		} else {

			return "TaskDetails not found with the id :" + tid;
		}

	}

	@Override
	public Task showtaskdetailsbyid(int tid) {

		Optional<Task> t = taskrepository.findById(tid);

		if (t.isPresent()) {
			return t.get();
		} else {
			throw new TaskDetailsNotFoundException(" Task details not found with Id:" + tid);
		}
	}

	@Override
	public List<Task> showAllTasks() {

		return taskrepository.findAll();

	}

}
