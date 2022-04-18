package com.example.aop2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LoggingAspectWithPointcut {

    // add @After advice in the findAccounts method
    // the @After advice method is invoked AFTER any @AfterReturning or @AfterThrowing advice methods in the same aspect class
    @After("com.example.aop2.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        // print out witch method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n>> Executing @After (finally) on method: " + method);
    }

    // add @AfterThrowing advice in the findAccounts method
    @AfterThrowing(
            pointcut = "com.example.aop2.aspect.AopExpressions.forDaoPackageNoGetterSetter()",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc){

        // print out witch method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println(">> The exception is: " + theExc);
    }

    @Before("com.example.aop2.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("3 >> Executing before advice on method");
    }
}
