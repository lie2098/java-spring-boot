package com.lye.aopdemo.dao;

import com.lye.aopdemo.model.Account;

import java.util.List;

public interface AccountDao {
    void addAccount(Account account, Boolean vipFlag);

    void doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

    List<Account> findAccounts();

    Account findAccount(Boolean flag);
}
