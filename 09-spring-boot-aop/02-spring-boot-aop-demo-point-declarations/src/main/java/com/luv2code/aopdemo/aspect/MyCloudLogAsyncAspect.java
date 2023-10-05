package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyCloudLogAsyncAspect {



    @Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")//AopExpressions also extentable
    public  void logToCloudAsync(){
        System.out.println("\n======>>> logging to cloud");
    }

}
