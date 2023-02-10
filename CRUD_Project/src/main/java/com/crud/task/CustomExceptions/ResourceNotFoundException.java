package com.crud.task.CustomExceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String mesg) {
		super(mesg);
	}	

}