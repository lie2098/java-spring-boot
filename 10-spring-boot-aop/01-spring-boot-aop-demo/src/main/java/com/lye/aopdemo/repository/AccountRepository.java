package com.lye.aopdemo.repository;

import com.lye.aopdemo.dao.AccountDao;
import com.lye.aopdemo.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository implements AccountDao {
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
}
