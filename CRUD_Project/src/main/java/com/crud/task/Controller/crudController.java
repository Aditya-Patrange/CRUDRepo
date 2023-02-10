package com.crud.task.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.crud.task.DTO.UserCrudDTO;
import com.crud.task.Services.UserCrudService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/user")
public class crudController {

	@Autowired
	private UserCrudService userCrudService;

	@GetMapping("/getusers")

	public ResponseEntity<?> getAllUsers() {

		return ResponseEntity.ok(userCrudService.getAllUsers());

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable long id) {


		return ResponseEntity.ok(userCrudService.getUserById(id));
	}

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody @Valid UserCrudDTO userDTO) {
			
			return ResponseEntity.ok(userCrudService.addUser(userDTO));

	}

	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUserDetails(@Valid @RequestBody  UserCrudDTO userDto, @PathVariable long id) {
		
		
		return ResponseEntity.ok(userCrudService.updateUser(userDto,id));
	}

	
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable("userId") long userId) {
		
			return userCrudService.deleteUser(userId);
		
	}
	

	@GetMapping("/getActiveUsers")
	public ResponseEntity<?> getAllActiveUsers() {
		
		return ResponseEntity.of(Optional.of(userCrudService.getAllActiveUsers()));
	}
	
	
	@GetMapping("/getAllDevUsers")
	public ResponseEntity<?> getAllDevUsers(){
		return ResponseEntity.of(Optional.of(userCrudService.getAllDevUsers()));

	}

}
