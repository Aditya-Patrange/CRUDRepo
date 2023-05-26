package useractivity.logs.services;

import useractivity.logs.dto.ActivityDto;
import useractivity.logs.dto.AddActivityDto;
import useractivity.logs.dto.ApiResponse;


public interface IActivityService {

	ApiResponse<?> saveActivity(ActivityDto data);

	ApiResponse<?> addActivity(AddActivityDto data);

	ApiResponse<?> getAvailableActivities();

	ApiResponse<?> deactivateKey(ActivityDto key);

//	ApiResponse<?> changeKeyStatus(KeyStatusDto key);

	
	
}
