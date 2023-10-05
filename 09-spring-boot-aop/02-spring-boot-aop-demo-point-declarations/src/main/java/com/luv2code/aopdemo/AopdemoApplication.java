package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficService){
		return runner->{
			//demoTheBeforeAdvidce(theAccountDAO,theMembershipDAO);
			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			//demoTheAfterAdvice(theAccountDAO);
			//demoTheAroundAdvice(theTrafficService);
			//demoTheAroundAdviceHandleException(theTrafficService);
			demoTheAroundAdviceRethrowException(theTrafficService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficService) {
		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");
		System.out.println("Calling getFortune()");

		boolean tripWire= true;
		String data = theTrafficService.getFortune(tripWire);
		System.out.println("\n My fortune is: "+data);
		System.out.println("End");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficService) {
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");

		boolean tripWire= true;
		String data = theTrafficService.getFortune(tripWire);
		System.out.println("\n My fortune is: "+data);
		System.out.println("End");
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficService) {
		System.out.println("\nMain Program: demoTheTrafficAdvice");
		System.out.println("Calling getFortune()");

		String data = theTrafficService.getFortune();
		System.out.println("\n My fortune is: "+data);
		System.out.println("End");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try {
			//add a boolean flag to simultane exceptions
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("Exception: "+exc);
		}
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try {
			//add a boolean flag to simultane exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("Exception: "+exc);
		}

		//display
		System.out.println("\nMain Program: ");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("---\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts =  theAccountDAO.findAccounts();

		//display
		System.out.println("\nMain Program: ");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("---\n");
	}

	private void demoTheBeforeAdvidce(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO) {
		Account myAccount = new Account("B","Gold");

		theAccountDAO.addAccount(myAccount,true);
		theMembershipDAO.addAccount();

		//call the accountdao getter setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		//String name = theAccountDAO.getName();
		//String code = theAccountDAO.getServiceCode();
	}


}
