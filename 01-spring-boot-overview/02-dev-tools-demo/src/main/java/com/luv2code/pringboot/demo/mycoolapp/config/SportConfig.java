package com.luv2code.pringboot.demo.mycoolapp.config;

import com.luv2code.pringboot.demo.mycoolapp.common.Coach;
import com.luv2code.pringboot.demo.mycoolapp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){

        return new SwimCoach();
    }
}
