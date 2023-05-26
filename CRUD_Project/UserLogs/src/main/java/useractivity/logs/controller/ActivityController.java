package useractivity.logs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import useractivity.logs.dto.ActivityDto;
import useractivity.logs.dto.AddActivityDto;
import useractivity.logs.exceptions.ResourceNotFoundException;
import useractivity.logs.services.IActivityService;

@RestController
@RequestMapping("/api/logs")
public class ActivityController {

	@Autowired
	private IActivityService activityService;
	
	@PostMapping("/activity")
	public ResponseEntity<?> saveActivity(@RequestBody ActivityDto data){
		return new ResponseEntity<>(activityService.saveActivity(data),HttpStatus.OK);
	}
	
	@PostMapping("/addKey")
	public ResponseEntity<?> addActivity(@RequestBody AddActivityDto data){
			return new ResponseEntity<>(activityService.addActivity(data),HttpStatus.OK);
	}
	
	@GetMapping("/allAvailableActivities")
	public ResponseEntity<?> getAvailableActivities(){
		return new ResponseEntity<>(activityService.getAvailableActivities(),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteKey")
	public ResponseEntity<?> deactivateKey(@RequestBody ActivityDto key){
		return new ResponseEntity<>(activityService.deactivateKey(key),HttpStatus.OK);
	}
	
	
	
	/**
	 * 
	 * @param key
	 * @return
	 * 
	 * @PostMapping("/key")
	public ResponseEntity<?> KeyActivationDeavtivation(@RequestBody KeyStatusDto key){
		return new ResponseEntity<>(activityService.changeKeyStatus(key),HttpStatus.OK);
	}
	 */
	


}
