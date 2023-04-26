package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Task;
import com.cg.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	public TaskService taskService;



	@PostMapping("/tasks") 
	public ResponseEntity<Task> addtask(@RequestBody Task task) {
	
		return new ResponseEntity<>(taskService.addtask(task), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateTasks")
	public ResponseEntity<Task> updatetaskdetails(@RequestBody Task task){
		return new ResponseEntity<>(taskService.updatetaskdetails(task),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/deleteTasks/{tid}")
	public ResponseEntity<Task> deletebyid(@PathVariable("tid")int tid){
		taskService.deletebyid( tid);
		return new ResponseEntity<>( HttpStatus.OK);
		
	}
	
	
	
	@GetMapping(value="/allTasks")
	public List<Task> showAllTasks(){
		
		return taskService.showAllTasks();
	}

	
	@PutMapping(value="/updatebyid/{tid}")
	public ResponseEntity<Task>updatetaskdetailsbyid(@PathVariable("tid")Task tid){
		taskService.updatetaskdetails( tid);
		return new ResponseEntity<>( HttpStatus.OK);
		
	}
		
		
	}
	
	
	
	
	
	

