package useractivity.logs.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import useractivity.logs.dto.ActivityDto;
import useractivity.logs.dto.AddActivityDto;
import useractivity.logs.dto.ApiResponse;
import useractivity.logs.model.ActivityTypeEntity;
import useractivity.logs.model.UserActivityEntity;
import useractivity.logs.repository.IActivityRepository;
import useractivity.logs.repository.IUserActivityRepository;
import useractivity.logs.utils.CommonUtils;
@Service
public class ActivityServiceImpl implements IActivityService{

	@Autowired
	private IActivityRepository iActivityRepository;
	
	@Autowired
	private IUserActivityRepository userActivityRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CommonUtils commonUtils;

	
	@Override
	public ApiResponse<?> saveActivity(ActivityDto data) {
		
			ActivityTypeEntity activityTypeEntity = iActivityRepository.findById(data.getActivityKey()).orElseThrow(()->new RuntimeException("Key not found !!"));
			if(activityTypeEntity.getStatus().equals(true)) {
				UserActivityEntity userActivityEntity = new UserActivityEntity();
				userActivityEntity.setActivityKeyU(activityTypeEntity.getActivityKey());
				userActivityEntity.setActivityDescription(activityTypeEntity.getActivityDescription());
				userActivityEntity.setUserId(data.getUserId());
				userActivityRepository.save(userActivityEntity);
				return commonUtils.setApiResponses(" Activity performed by uid : " + data.getUserId(), "Activity performed successfully...", true) ;
			}
			
			return commonUtils.setApiResponses(null, "Activity can't be performed, status in De-active !!", false) ;		
	}
	
	
	

	@Override
	public ApiResponse<?> addActivity(AddActivityDto data) {
		ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
		if(activityTypeEntity.getActivityKey() == null ) {
										
				activityTypeEntity.setActivityID(data.getActivityID());
				activityTypeEntity.setActivityKey(data.getActivityKey());
				activityTypeEntity.setActivityDescription(data.getActivityDescription());
				activityTypeEntity.setStatus(true);
				activityTypeEntity.setCreatedOn(data.getCreatedOn());
				ActivityTypeEntity activity = iActivityRepository.save(activityTypeEntity);
				return commonUtils.setApiResponses(mapper.map(activity, ActivityDto.class), "Added new Key", true) ;			
			
		}
		return commonUtils.setApiResponses(null, " Duplicate keys not allowed !!", false);
	}


	@Override
	public ApiResponse<?> getAvailableActivities() {
		
		return commonUtils.setApiResponses(iActivityRepository.findAll(), "Listed All available activities", true);
	}


	@Override
	public ApiResponse<?> deactivateKey(ActivityDto key) {
		ActivityTypeEntity activityTypeEntity = new ActivityTypeEntity();
		activityTypeEntity = iActivityRepository.findById(key.getActivityKey()).orElseThrow(()->new RuntimeException("Key not found !!"));
		if(activityTypeEntity.getStatus().equals(true)) {
			activityTypeEntity.setStatus(false);
		iActivityRepository.save(activityTypeEntity);
			return commonUtils.setApiResponses("Uid : "+key.getUserId() , "Key deactivated !!", true);
			
		}
		return commonUtils.setApiResponses(activityTypeEntity.getStatus(), "Change Key status : Active / De-active ", false);
	}
	
}
