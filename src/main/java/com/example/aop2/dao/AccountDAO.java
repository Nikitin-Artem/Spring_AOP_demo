package com.example.aop2.dao;

import com.example.aop2.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    // for AfterReturning_demo
    public List<Account> findAccounts(){
        List<Account> list = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Ben", "Platinum");
        Account temp3 = new Account("Robin", "Gold");

        list.add(temp1);
        list.add(temp2);
        list.add(temp3);

        return list;
    }

    // for AfterThrowing_demo
    public List<Account> findAccounts(boolean tripWire){

        if(tripWire){
            throw new RuntimeException("Simulating exception for @AfterThrowing advice");
        }

        List<Account> list = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Ben", "Platinum");
        Account temp3 = new Account("Robin", "Gold");

        list.add(temp1);
        list.add(temp2);
        list.add(temp3);

        return list;
    }

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep now");
    }


    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
