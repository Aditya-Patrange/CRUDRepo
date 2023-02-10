package com.crud.task.Services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.task.CustomExceptions.ResourceNotFoundException;
import com.crud.task.DTO.ApiResponse;
import com.crud.task.DTO.UserCrudDTO;
import com.crud.task.Entities.UserCrudEntity;
import com.crud.task.Repositories.UserCrudRepository;

@Service
public class UserCrudService {

	@Autowired
	private UserCrudRepository userCrudRepository;
	@Autowired
	private ModelMapper mapper;

	public List<UserCrudEntity> getAllUsers() {
		return userCrudRepository.findAll();
	}

	//find a user by id
	public UserCrudDTO getUserById(long id) {
		UserCrudEntity userEntity = userCrudRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found!!")); //custom exception
		return mapper.map(userEntity, UserCrudDTO.class);
	}

	// add user details
	public UserCrudDTO addUser(UserCrudDTO userDTO) {
		UserCrudEntity entity = mapper.map(userDTO, UserCrudEntity.class);
		UserCrudEntity saveEntity = userCrudRepository.save(entity);
		UserCrudDTO result = mapper.map(saveEntity, UserCrudDTO.class);
		return result;
	}

	//update details of a user
	public String updateUser(UserCrudDTO userDTO, long uId) {
		UserCrudEntity userEntity = userCrudRepository.findById(uId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found!!")); //custom exception
		userEntity.setName(userDTO.getName());
		userEntity.setAction(userDTO.getAction());
		userEntity.setWork(userDTO.getWork());
		userCrudRepository.save(userEntity);
		return "Updated Successfully!!!";
	}

	//delete a user
	public String deleteUser(long uID) {
		if (userCrudRepository.existsById((int) uID)) {
			userCrudRepository.deleteById((int) uID);
			return "user deleted with user id - " + uID;
		} else {
			return "No user found!!!";
		}
		
		
	}

	//custom query find all active & dev users method
	public List<UserCrudEntity> getAllActiveUsers() {
		return userCrudRepository.findAllActiveUsers();
	}
	
	public List<UserCrudEntity> getAllDevUsers() {
		return userCrudRepository.findAllDevUser();
	}
	
}
