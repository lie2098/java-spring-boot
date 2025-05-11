package com.lye.aopdemo.repository;

import com.lye.aopdemo.dao.AccountDao;
import com.lye.aopdemo.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository implements AccountDao {

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account account, Boolean vipFlag) {
        System.out.println(getClass() + " addAccount");
        System.out.println(account);
        System.out.println("is VIP: " + (vipFlag ? "Yes" : "No"));
    }

    @Override
    public void doWork() {
        System.out.println(getClass() + " Doing work...");
    }

    @Override
    public String getName() {
        System.out.println(getClass() + " getName");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass() + " setName");
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println(getClass() + " getServiceCode");
        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " setServiceCode");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        return List.of(
                new Account("My", "Bronze"),
                new Account("Self", "Gold"),
                new Account("And", "Platinum"),
                new Account("I", "Diamond")
        );
    }

    @Override
    public Account findAccount(Boolean flag) {
        if (!flag) {
            throw new RuntimeException("exception findAccount");
        }

        return findAccounts().get(0);
    }
}
