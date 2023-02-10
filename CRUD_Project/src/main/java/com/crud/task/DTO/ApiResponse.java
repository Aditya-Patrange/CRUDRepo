package com.crud.task.DTO;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class ApiResponse {
	private LocalDateTime timeStamp;
	private String message;

	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}
}
