package com.statestreet.interview.studentregistration.repository;

import com.statestreet.interview.studentregistration.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepo extends CrudRepository<Course,Long> {
}
