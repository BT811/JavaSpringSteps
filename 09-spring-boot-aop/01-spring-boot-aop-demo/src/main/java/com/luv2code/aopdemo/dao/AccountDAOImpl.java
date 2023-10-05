package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+": doing my db work: adding an account");
    }
}
