package com.example.aop2.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

    // shortcut
    @Pointcut("execution(* com.example.aop2.dao.*.*(..))")
    public void forDaoPackage(){}

    // pointcut for getter methods
    @Pointcut("execution(* com.example.aop2.dao.*.get*(..))")
    public void getter(){}

    // pointcut for setter methods
    @Pointcut("execution(* com.example.aop2.dao.*.set*(..))")
    public void setter(){}

    // pointcut exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

}
