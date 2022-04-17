package com.example.aop2.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
    }
}
