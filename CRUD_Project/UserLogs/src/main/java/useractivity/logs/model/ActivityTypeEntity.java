package useractivity.logs.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class ActivityTypeEntity {

	@Column(unique=true)
	@Nonnull
	private int activityID;
	@Id
	private String activityKey;
	@Nonnull
	private String activityDescription;
	
	private Boolean status; 
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDate createdOn;
		
	
}
