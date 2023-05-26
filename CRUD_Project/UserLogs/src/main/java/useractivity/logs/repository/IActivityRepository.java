package useractivity.logs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import useractivity.logs.model.ActivityTypeEntity;

@Repository
public interface IActivityRepository extends JpaRepository<ActivityTypeEntity, String>{

	@Query(value="select k.activityDescription from ActivityTypeEntity k where k.activityKey = :key")
	ActivityTypeEntity getByDescription(@Param("key") String key);
	
//	@Query(value= "select k from ActivityTypeEntity k where k.activityKey = :key")
//	ActivityTypeEntity getDataOfKey(@Param("key") String key);
	
}
