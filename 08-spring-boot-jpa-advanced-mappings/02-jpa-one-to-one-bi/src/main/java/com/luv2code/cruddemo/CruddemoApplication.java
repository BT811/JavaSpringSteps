package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
		};
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
