package com.example.aop2;

import com.example.aop2.config.DemoConfig;
import com.example.aop2.dao.AccountDAO;
import com.example.aop2.dao.MembershipDAO;
import com.example.aop2.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        // read Spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        Account account = new Account();
        accountDAO.addAccount(account, true);
        accountDAO.doWork();
        accountDAO.goToSleep();

        // call the accountDAO getter/setter methods
        accountDAO.setName("kek");
        accountDAO.setServiceCode("gold");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();


        // call the membership business method
        membershipDAO.addAccount();

        context.close();
    }
}
