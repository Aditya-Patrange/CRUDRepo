package useractivity.logs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import useractivity.logs.dto.ActivityDto;
import useractivity.logs.services.IUserActivityService;



@RestController
@RequestMapping("/api/logs")
public class UserController {
	
	@Autowired
	private IUserActivityService userActivityService;
	
	
	@GetMapping("/activitieshistory")
	public ResponseEntity<?> getAllActivityHistory(){
		return new ResponseEntity<>(userActivityService.getAllActivitiesHistory(),HttpStatus.OK);
	}
	
	@PostMapping("/uniqueDataPerKey")
	public ResponseEntity<?> getHitsUniquePerKey(@RequestBody ActivityDto key){
		return new ResponseEntity<>(userActivityService.getDataBasedOnKey(key),HttpStatus.OK);
	}
	
	
	
}
