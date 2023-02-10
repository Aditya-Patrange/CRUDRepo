package com.crud.task.CustomExceptions;

@SuppressWarnings("serial")
public class MethodArgumentNotValidException extends Exception{
	
	public MethodArgumentNotValidException(String mesg) {
		super(mesg);
	}	

}
