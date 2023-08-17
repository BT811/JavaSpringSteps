package com.luv2code.pringboot.demo.mycoolapp.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.Socket;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    @Override

    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
