package com.cg.excpetions;

public class TaskIdNotFoundException extends RuntimeException {
	
	public TaskIdNotFoundException (String str)
	{
		super(str);
	}

}
