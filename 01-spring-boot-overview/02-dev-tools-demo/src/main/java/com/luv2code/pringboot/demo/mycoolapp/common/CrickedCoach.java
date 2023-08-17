package com.luv2code.pringboot.demo.mycoolapp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CrickedCoach implements Coach{
    public CrickedCoach(){
        System.out.println("In constructor(): "+getClass().getSimpleName());
    }
/*
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In do my start up stuff(): "+getClass().getSimpleName());
    }
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In do my clean up stuff(): "+getClass().getSimpleName());
    }

 */

    @Override
    public String getDailyWorkout() {
        return "Practive fast bowling for 15 minutes";
    }
}
