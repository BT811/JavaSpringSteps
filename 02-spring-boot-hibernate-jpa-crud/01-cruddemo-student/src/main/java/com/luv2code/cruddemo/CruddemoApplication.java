package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
		public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
			return runner ->{
				createStudent(studentDAO);
				//readStudent(studentDAO);
				//queryForStudents(studentDAO);
				//queryForStudentsByLastName(studentDAO);
				//updateStudent(studentDAO);
				//deleteStudent(studentDAO);
				//deleteAll(studentDAO);
			};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("dONE");
		studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student myStudent = studentDAO.findById(studentId);
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudent = studentDAO.findAll();
		for (Student tempStudent: theStudent) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		int theId= 1;
		Student myStudent = studentDAO.findById(theId);
		System.out.println(myStudent.getFirstName());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creatn new student object...");
		Student tempStudent = new Student("paul","Doe","Pauli@hotmail.com");
		studentDAO.save(tempStudent);
	}

}
