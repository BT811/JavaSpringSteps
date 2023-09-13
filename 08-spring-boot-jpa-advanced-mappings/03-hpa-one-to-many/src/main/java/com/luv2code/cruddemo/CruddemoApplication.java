package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createInstructor(appDAO);
			//findInstuctor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetailById(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			//deleteInstructor(appDAO);
			//deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		appDAO.deleteCourseById(theId);
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse= appDAO.findCourseById(theId);
		tempCourse.setTitle("Java-102");
		appDAO.update(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=5;
		Instructor tempInstructor= appDAO.findInstructorById(theId);

		tempInstructor.setLastName("Trk");

		appDAO.update(tempInstructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 5;
		System.out.println("Finding insturctor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Instructor: "+tempInstructor);
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=5;
		Instructor tempInstructor= appDAO.findInstructorById(theId);

		List<Course> courses=appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("the associated courses "+tempInstructor.getCourses());

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=5;
		System.out.println("Instructor id: "+theId);

		Instructor tempInstructor= appDAO.findInstructorById(theId);

		System.out.println("Courses: "+tempInstructor.getCourses());
		System.out.println("Done");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor=new Instructor("Lalo","Lola","ola@hotmail.com");
		//create I.Detail
		InstructorDetail tempInstructorDetail=new InstructorDetail(
				"http://www.LaloLola.com/youtube",
				"Games"
		);
		//associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//create some courses
		Course tempCourse1= new Course("Java-101");
		Course tempCourse2= new Course("Phyton-101");
		 //add course to Instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		int theId=1;
		appDAO.deleteInstructorDetailById(theId);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=1;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("Instrucotr detail: "+tempInstructorDetail);
		System.out.println("The associated instructor: "+tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id=1;
		appDAO.deleteInstructorById(id);
	}

	private void findInstuctor(AppDAO appDAO) {
		int theId=1;
		Instructor tempInstructor= appDAO.findInstructorById(theId);
		System.out.println("Instructor : "+tempInstructor);
		System.out.println("the associated instructor: "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		//create Instructor
		Instructor tempInstructor=new Instructor("Berk","Tr","abc@hotmail.com");
		//create I.Detail
		InstructorDetail tempInstructorDetail=new InstructorDetail(
				"http://www.abcd.com/youtube",
				"Manga-History-Movie"
		);
		//associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving...");
		appDAO.save(tempInstructor);
	}

}
