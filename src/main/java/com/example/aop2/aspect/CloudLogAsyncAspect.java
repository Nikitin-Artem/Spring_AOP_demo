package com.example.aop2.aspect;

import com.example.aop2.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class CloudLogAsyncAspect {

    // add @Around advice in the findAccounts method
    @Around("execution(* com.example.aop2.service.TrafficService.getTraffic(..))")
    public Object aroundGetTraffic(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out witch method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println(e);

            result = "Major accident! But AOP helicopter is on the way!";
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display id
        long duration = end - begin;
        System.out.println(">> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    // With JoinPoint
    @Before("com.example.aop2.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    private void logToCloudAsync(JoinPoint joinPoint) {
        System.out.println("2 >> Logging to Cloud in async fashion");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method Signature: " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object x : args) {
            System.out.println(x);

            if (x instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) x;

                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }
    }
}
