package useractivity.logs.services;

import useractivity.logs.dto.ActivityDto;
import useractivity.logs.dto.ApiResponse;

public interface IUserActivityService {

	public ApiResponse<?> getAllActivitiesHistory();

	public ApiResponse<?> getDataBasedOnKey(ActivityDto key);

	//UserActivityEntity saveUserActivity(ActivityDto data);

	//UserActivityEntity addUserActivity(UserActivityDto data);
	//UserActivityEntity addUserActivity(UserActivityEntity data);
}
