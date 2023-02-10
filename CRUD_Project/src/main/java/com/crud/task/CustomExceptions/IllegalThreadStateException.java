package com.crud.task.CustomExceptions;


@SuppressWarnings("serial")
public class IllegalThreadStateException extends RuntimeException{

	public IllegalThreadStateException(String mesg) {
		super(mesg);
	}	

}
