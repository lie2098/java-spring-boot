package com.lye.aopdemo.service;

import com.lye.aopdemo.dao.AccountDao;
import com.lye.aopdemo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public String getName() {
        return accountDao.getName();
    }

    public void setName(String name) {
        accountDao.setName(name);
    }

    public String getServiceCode() {
        return accountDao.getServiceCode();
    }

    public void setServiceCode(String serviceCode) {
        accountDao.setServiceCode(serviceCode);
    }

    public List<Account> findAccounts() {
        return accountDao.findAccounts();
    }

    public Account findAccount(boolean flag) {
        return accountDao.findAccount(flag);
    }
}
