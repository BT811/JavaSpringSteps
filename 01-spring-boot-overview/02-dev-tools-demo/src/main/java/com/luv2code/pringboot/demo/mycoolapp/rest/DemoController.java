package com.luv2code.pringboot.demo.mycoolapp.rest;

import com.luv2code.pringboot.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    // Constuction injection
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach){
        myCoach = theCoach;
    }


    /* Setter İnjection
    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }

     */
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
