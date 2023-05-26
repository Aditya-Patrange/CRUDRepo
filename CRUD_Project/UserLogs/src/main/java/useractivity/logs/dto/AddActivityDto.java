package useractivity.logs.dto;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddActivityDto {

	
	private int activityID;
	private String activityKey;
	private String activityDescription;
	private boolean status; 
	@CreationTimestamp
	private LocalDate createdOn;
}
