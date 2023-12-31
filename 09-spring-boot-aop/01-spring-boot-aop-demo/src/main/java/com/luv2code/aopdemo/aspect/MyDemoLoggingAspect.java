package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    //@Before("execution(public void addAccount())")
    //@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(* add*())") modifier is optional
    //@Before("execution(void addAccount())")
    //@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
    //@Before("execution(* add*(..))")
    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public  void beforeAddAcountAdvice(){
        System.out.println("\n======>>> @Before advice");
    }
}
