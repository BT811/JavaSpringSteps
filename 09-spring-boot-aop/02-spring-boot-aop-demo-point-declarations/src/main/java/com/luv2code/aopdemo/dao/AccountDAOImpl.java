package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        //simulate an exception
        if(tripWire){
            throw new RuntimeException("This is a serious exception!!!!");
        }
        List<Account> myAccounts = new ArrayList<>();
        //creatre sample account
        Account account1= new Account("johny","Silver");
        Account account2 = new Account("Maykl","Platinium");
        //add them to list
        myAccounts.add(account1);
        myAccounts.add(account2);
        return myAccounts;
    }

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+": doing my db work: adding an account");
    }

    public String getName() {
        System.out.println(getClass()+": in getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": in setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": in getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": in setServiceCode");
        this.serviceCode = serviceCode;
    }
}
