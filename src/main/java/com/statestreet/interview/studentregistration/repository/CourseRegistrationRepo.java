package com.statestreet.interview.studentregistration.repository;

import com.statestreet.interview.studentregistration.model.Course;
import com.statestreet.interview.studentregistration.model.CourseRegistration;
import org.springframework.data.repository.CrudRepository;

public interface CourseRegistrationRepo extends CrudRepository<CourseRegistration,Long> {
}
