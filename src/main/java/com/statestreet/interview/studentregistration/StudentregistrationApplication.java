package com.statestreet.interview.studentregistration;

import com.statestreet.interview.studentregistration.dao.RegistrationDAO;
import com.statestreet.interview.studentregistration.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
//@EnableScheduling
public class StudentregistrationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentregistrationApplication.class, args);
	}

	@Bean
	public RegistrationDAO getHelloService(){
		return  new RegistrationDAO();
	}

	@Override
	public void run(String... args) throws Exception{

		//getHelloService().addStudent();
		String courseName = "Software Programming";
		List<Student> sortedStudents =  getHelloService().findStudentByCourse(courseName);
		sortedStudents.forEach(student -> System.out.println("Student Name with course Software Programming "+student.getName()));
		//Delete one Student
		//getHelloService().delete(sortedStudents.get(0));
		//Student - Courses after delete
		List<Student> sortedStudentsAfterdelete =  getHelloService().findStudentByCourse(courseName);
		sortedStudentsAfterdelete.forEach(student -> System.out.println("After Delete, Student with Course Software Programming "+student.getName()));




	}

}
