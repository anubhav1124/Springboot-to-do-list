package com.cg.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

public class Task {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
	private int tid;
  
  @Column(name="taskname")
	private String taskName;
  
  @Column(name="taskstatus")
	private String taskStatus;
  
  @ElementCollection
  @CollectionTable(name="tasklist")
  @Column(name="tasklist")
	private List<String> taskList;
	
	public Task(){}

	public Task(int tid, String taskName, String taskStatus, List<String> taskList) {
		super();
		this.tid = tid;
		this.taskName = taskName;
		this.taskStatus = taskStatus;
		//this.taskList = taskList;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	/*
	 * public List<String> getTaskList() { return taskList; }
	 * 
	 * public void setTaskList(List<String> taskList) { this.taskList = taskList; }
	 */

	@Override
	public String toString() {
		return "Task [tid=" + tid + ", taskName=" + taskName + ", taskStatus=" + taskStatus + ", taskList=" + taskList
				+ "]";
	}
	
	
		
	
}
