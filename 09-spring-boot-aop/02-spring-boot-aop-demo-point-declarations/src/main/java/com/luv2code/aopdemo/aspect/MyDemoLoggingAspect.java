package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
    @Around("execution (* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n======> @Around, method: "+method);

        long begin = System.currentTimeMillis();

        Object result = null;
        try {
           result = theProceedingJoinPoint.proceed();
        }catch (Exception exc){
            System.out.println(exc.getMessage());
            result ="Major accident!But no worries, helicopter is on the way!!";
            //Rethrow exception: We use it to record that the problem occurred.
            //System.out.println("@Around advice : We have  a problem "+exc);
            //throw exc;
        }


        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("\n=====> Duration: "+duration/1000.0+" seconds");
        return result;
    }
    @After("execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJointPoint){
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n======> @After, method: "+method);
        
    }
    
    @AfterThrowing(
            pointcut = "execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingExceptionAccountsAdvice(JoinPoint theJointPoint,Throwable theExc){
        System.out.println("@AfterThrowing");
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("===> Method: "+method);

        System.out.println("===> Exception: "+theExc);

    }

    @AfterReturning(
            pointcut = "execution (* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(JoinPoint theJointPoint, List<Account> result){
        System.out.println("@AfterReturning");
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("===> Method: "+method);
        System.out.println("===> Result: "+result);
        //post -process the data...

        //convert the account names to uppercase
        converAccountNamesToUpperCase(result);

        System.out.println("===> Result: "+result);
    }


    private void converAccountNamesToUpperCase(List<Account> result) {
        //loop through accounts
        for(Account tempAccount : result){
            //get uppercase version
            String theUpperName = tempAccount.getName().toUpperCase();
            //update
            tempAccount.setName(theUpperName);
        }
    }

    //@Before("execution(public void addAccount())")
    //@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(* add*())") modifier is optional
    //@Before("execution(void addAccount())")
    //@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
    //@Before("execution(* add*(..))")
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}
    //create pointcut for getter / setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter(){}
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private  void forDaoPackageNoGetterSetter(){}

    //@Before("forDaoPackage()")
    @Before("forDaoPackageNoGetterSetter()")
    public  void beforeAddAcountAdvice(JoinPoint theJointPoint){
        System.out.println("\n======>>> @Before advice");
    //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJointPoint.getSignature();
        System.out.println("Method: "+methodSignature);

    //display method arguments
        Object[] args = theJointPoint.getArgs();
        for(Object tempArg: args){
           System.out.println(tempArg);
            if(tempArg instanceof Account){
                //downcast and print account specific stuff
                Account theAccount =(Account) tempArg;

                System.out.println("Account name: "+theAccount.getName());
            }
        }
    }
    //Add a new advie for @AfterReturning on the findAccounts methot



}
