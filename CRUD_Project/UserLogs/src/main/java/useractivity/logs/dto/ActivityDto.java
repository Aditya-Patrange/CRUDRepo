package useractivity.logs.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto {

	private String activityKey;
	//private String activityDescription;
	private Long userId;
}
