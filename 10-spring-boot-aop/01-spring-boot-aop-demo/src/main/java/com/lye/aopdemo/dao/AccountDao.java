package com.lye.aopdemo.dao;

import com.lye.aopdemo.model.Account;

public interface AccountDao {
    void addAccount(Account account, Boolean vipFlag);
    void doWork();
}
