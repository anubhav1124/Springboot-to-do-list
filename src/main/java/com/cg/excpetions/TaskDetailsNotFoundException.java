package com.cg.excpetions;

public class TaskDetailsNotFoundException extends RuntimeException {
	public TaskDetailsNotFoundException (String msg)
	{
		super(msg);
	}
}
