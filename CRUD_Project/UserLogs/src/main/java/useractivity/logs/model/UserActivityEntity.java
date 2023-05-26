package useractivity.logs.model;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserActivityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userActivityId;
	@Nonnull
	private String activityDescription;
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdOn;
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name="activityKey")
//	private ActivityTypeEntity activityKeyFK;
	@Nonnull
	private String activityKeyU;
	
	private long userId;

	
	
	
}
