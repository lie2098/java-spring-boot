package com.lye.aopdemo.repository;

import com.lye.aopdemo.dao.MembershipDao;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipRepository implements MembershipDao {
    @Override
    public boolean addNewAccount() {
        return true;
    }
}
