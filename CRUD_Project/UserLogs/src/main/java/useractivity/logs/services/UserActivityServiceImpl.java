package useractivity.logs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import useractivity.logs.dto.ActivityDto;
import useractivity.logs.dto.ApiResponse;
import useractivity.logs.repository.IUserActivityRepository;
import useractivity.logs.utils.CommonUtils;

@Service
public class UserActivityServiceImpl implements IUserActivityService{
	
	
	@Autowired
	private IUserActivityRepository iUserActivityRepository;
	
	@Autowired
	private CommonUtils commonUtils;
	
	@Override
	public ApiResponse<?> getAllActivitiesHistory() {
		
		return commonUtils.setApiResponses(iUserActivityRepository.findAll(), "Activities History Listed..", true);
	}

	@Override
	public ApiResponse<?> getDataBasedOnKey(ActivityDto key) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
