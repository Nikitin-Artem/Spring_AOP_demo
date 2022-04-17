package com.example.aop2.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LoggingAspectWithPointcut {

    @Before("com.example.aop2.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("3 >> Executing before advice on method");
    }
}
