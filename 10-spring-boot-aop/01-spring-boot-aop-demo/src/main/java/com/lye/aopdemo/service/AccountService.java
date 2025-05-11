package com.lye.aopdemo.service;

import com.lye.aopdemo.dao.AccountDao;
import com.lye.aopdemo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountService {
    private final AccountDao accountDao;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void addAccount(Account account, Boolean vipFlag) {
        accountDao.addAccount(account, vipFlag);
    }

    public void doWork() {
        accountDao.doWork();
    }
}
