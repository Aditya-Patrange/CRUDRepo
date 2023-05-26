package useractivity.logs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import useractivity.logs.dto.ActivityDto;
import useractivity.logs.model.UserActivityEntity;

@Repository
public interface IUserActivityRepository extends JpaRepository<UserActivityEntity, Integer>{

	@Query(value="select u from UserActivityEntity u where u.activityKeyU = :activityKey")
	UserActivityEntity getDataPerKey(@Param("activityKey") ActivityDto activityKeyU);
	
}
