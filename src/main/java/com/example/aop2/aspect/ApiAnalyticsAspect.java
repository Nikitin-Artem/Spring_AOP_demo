package com.example.aop2.aspect;

import com.example.aop2.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class ApiAnalyticsAspect {

    // add @AfterReturning advice in the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.example.aop2.dao.AccountDAO.findAccounts(..))",
            returning = "resultQWE")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> resultQWE) {

        // print witch method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n>> Executing @AfterReturning on method: " + method);

        // print out the result of the method call
        System.out.println(">> result is: " + resultQWE);

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(resultQWE);
        System.out.println("\nConverting our @AfterResult on method to Uppercase: ");
        System.out.println(">> result is: " + resultQWE);

    }

    @Before("com.example.aop2.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n1 >> Performing API analytics");
    }

    // convert the account names to uppercase
    private void convertAccountNamesToUpperCase(List<Account> resultQWE) {
        for(Account tempAccount : resultQWE){
            String theUpperName = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperName);
        }
    }
}
