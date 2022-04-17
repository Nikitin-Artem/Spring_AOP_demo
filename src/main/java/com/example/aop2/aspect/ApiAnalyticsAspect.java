package com.example.aop2.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ApiAnalyticsAspect {

    @Before("com.example.aop2.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n1 >> Performing API analytics");
    }
}
