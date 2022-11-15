package com.statestreet.interview.studentregistration.dao;

import com.statestreet.interview.studentregistration.model.Course;
import com.statestreet.interview.studentregistration.model.CourseRegistration;
import com.statestreet.interview.studentregistration.model.Student;
import com.statestreet.interview.studentregistration.repository.CourseRegistrationRepo;
import com.statestreet.interview.studentregistration.repository.CourseRepo;
import com.statestreet.interview.studentregistration.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RegistrationDAO {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    CourseRegistrationRepo registrationRepo;

    /**
     * Add Student along with courses for registration.
     */
    @Transactional
    public void addStudent(){

        //First Add 4 different courses
        List<CourseRegistration> coursesRegistrationList = new ArrayList<CourseRegistration>();
        List<String> courseList = Arrays.asList("Software Programming","Computer Networking","Software Security","AI/Machine Learning");
        List<String> studentList = Arrays.asList("Ryan","Bob","Alex","Arpan");

        Course softwarePrograming = new Course();
        softwarePrograming.setName(courseList.get(0));
        Course networking = new Course();
        networking.setName(courseList.get(1));
        Course security = new Course();
        security.setName(courseList.get(2));
        Course aiML = new Course();
        aiML.setName(courseList.get(3));

        //First Student Registration
        Student firstStudent = new Student();
        firstStudent.setName(studentList.get(0));
        CourseRegistration firstRegistration = new CourseRegistration();
        firstRegistration.setCourse(softwarePrograming);
        firstRegistration.setStudent(firstStudent);
        coursesRegistrationList.add(firstRegistration);

        CourseRegistration secondRegistration = new CourseRegistration();
        secondRegistration.setCourse(networking);
        secondRegistration.setStudent(firstStudent);
        coursesRegistrationList.add(secondRegistration);

        CourseRegistration thirdRegistration = new CourseRegistration();
        thirdRegistration.setCourse(security);
        thirdRegistration.setStudent(firstStudent);
        coursesRegistrationList.add(thirdRegistration);

        //Second Student Registration
        Student secondStudent = new Student();
        secondStudent.setName(studentList.get(1));

        CourseRegistration fourthRegistration = new CourseRegistration();
        fourthRegistration.setCourse(softwarePrograming);
        fourthRegistration.setStudent(secondStudent);
        coursesRegistrationList.add(fourthRegistration);


        CourseRegistration fifthRegistration = new CourseRegistration();
        fifthRegistration.setCourse(security);
        fifthRegistration.setStudent(secondStudent);
        coursesRegistrationList.add(fifthRegistration);

        //Third Student Registration
        Student thirdStudent = new Student();
        thirdStudent.setName(studentList.get(2));
        CourseRegistration sixthRegistration = new CourseRegistration();
        sixthRegistration.setCourse(aiML);
        sixthRegistration.setStudent(thirdStudent);
        coursesRegistrationList.add(sixthRegistration);

        registrationRepo.saveAll(coursesRegistrationList);

    }


    /**
     * Find Stud
     * @param courseName
     * @return
     */
    @Transactional(readOnly = true)
    public List<Student> findStudentByCourse(String courseName){
        List<Student> students = studentRepo.findStudentByCourse(courseName);
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        return students;
    }


    /**
     * Delete Student
     * @param student
     */
    @Transactional
    public void delete(Student student){
        //Delete a Student
         studentRepo.delete(student);
    }


}
