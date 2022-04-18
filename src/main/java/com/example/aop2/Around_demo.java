package com.example.aop2;

import com.example.aop2.config.DemoConfig;
import com.example.aop2.dao.AccountDAO;
import com.example.aop2.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Around_demo {
    public static void main(String[] args) {

        // read Spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accounts = accountDAO.findAccounts();

        System.out.println("\n\nMain program: AfterReturning_demo");
        System.out.println("----");

        System.out.println(accounts + "\n");

        context.close();
    }
}
