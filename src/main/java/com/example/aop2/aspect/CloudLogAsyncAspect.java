package com.example.aop2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class CloudLogAsyncAspect {

    @Before("com.example.aop2.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    private void logToCloudAsync(JoinPoint joinPoint){
        System.out.println("2 >> Logging to Cloud in async fashion");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method Signature: " + methodSignature);

        // display method arguments
    }
}
