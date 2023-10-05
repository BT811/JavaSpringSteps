package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		return runner->{
			demoTheBeforeAdvidce(theAccountDAO,theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvidce(AccountDAO theAccountDAO,MembershipDAO theMemebershipDAO) {
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount,true);
		theMemebershipDAO.addAccount();
	}


}
