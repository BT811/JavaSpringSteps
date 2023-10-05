package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//aspect optional
public class AopExpressions {
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}
    //create pointcut for getter / setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public void getter(){}
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public  void forDaoPackageNoGetterSetter(){}

}
