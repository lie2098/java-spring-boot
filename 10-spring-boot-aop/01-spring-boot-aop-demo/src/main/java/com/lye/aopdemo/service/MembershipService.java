package com.lye.aopdemo.service;

import com.lye.aopdemo.dao.MembershipDao;
import org.springframework.stereotype.Service;

@Service
public class MembershipService {
    private final MembershipDao membershipDao;

    public MembershipService(MembershipDao membershipDao) {
        this.membershipDao = membershipDao;
    }

    public void addNewAccount() {
        System.out.println(getClass() + " is succcess " + membershipDao.addNewAccount());
    }
}
