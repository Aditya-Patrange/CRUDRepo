package com.crud.task.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.task.DTO.UserCrudDTO;
import com.crud.task.Entities.UserCrudEntity;


@Repository
public interface UserCrudRepository extends JpaRepository<UserCrudEntity , Integer>{

	public Optional<UserCrudEntity> findById(long id);

	public UserCrudDTO save(UserCrudDTO userDTO);
	
	@Query("SELECT u FROM UserCrudEntity u WHERE u.action = 'ACTIVE'")
	List<UserCrudEntity> findAllActiveUsers();
	
	@Query("SELECT w FROM UserCrudEntity w WHERE w.work = 'DEVOPS'")
	List<UserCrudEntity> findAllDevUser();
}
