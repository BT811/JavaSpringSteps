package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.Soundbank;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{

			//createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourse(appDAO);
			//addMoreCourseForStudent(appDAO);
			//deleteCourse(appDAO);
            //deleteStudent(appDAO);


		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId=1;
		appDAO.deleteStudentById(theId);
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("Deletin course id : "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("done");
	}

	private void addMoreCourseForStudent(AppDAO appDAO) {
		int theId=2;
		Student tempStudent = appDAO.findStudentAndCourseById(theId);

		Course tempCourses1=new Course("How can you fly-101");
		Course tempCourses2=new Course("How can you die-101");
		//add courses to student
		tempStudent.addCourse(tempCourses1);
		tempStudent.addCourse(tempCourses2);

		System.out.println("Saving student "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());

		appDAO.update(tempStudent);

	}

	private void findStudentAndCourse(AppDAO appDAO) {
		int theId=2;
		Student tempStudent = appDAO.findStudentAndCourseById(theId);
		System.out.println("Student: "+tempStudent);
		System.out.println("Course: "+tempStudent.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId= 10;
		Course tempCourse = appDAO.findCourseAndStudentsById(theId);
		System.out.println("Course: "+tempCourse);
		System.out.println("Students: "+tempCourse.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course tempCourse = new Course("C-101");

		Student tempStudent1= new Student("Berk","Tr","abc@hotmail.com");
		Student tempStudent2= new Student("John","Doe","coni@hotmail.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		System.out.println("Saving the course: "+tempCourse);
		System.out.println("associated: "+tempCourse.getStudents());

		appDAO.save(tempCourse);
	}


}
