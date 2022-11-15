package com.statestreet.interview.studentregistration.repository;

import com.statestreet.interview.studentregistration.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends CrudRepository<Student,Long> {

    @Query("select s from Student s join s.registrations sr on sr.student = s.id join Course c on sr.course=c.id where c.name = :name")
    List<Student> findStudentByCourse(@Param("name") String courseName);
}
