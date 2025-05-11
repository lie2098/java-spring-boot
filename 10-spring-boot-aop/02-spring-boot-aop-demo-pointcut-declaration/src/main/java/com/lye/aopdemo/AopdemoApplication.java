package com.lye.aopdemo;

import com.lye.aopdemo.model.Account;
import com.lye.aopdemo.service.AccountService;
import com.lye.aopdemo.service.MembershipService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean

    public CommandLineRunner commandLineRunner(AccountService accountService,
                                               MembershipService membershipService) {
        return runner -> {
//            theBeforeAdvice(accountService, membershipService);
//            theAfterReturningAdvice(accountService);
            theAfterThrowingAdvice(accountService);
        };
    }

    private void theAfterThrowingAdvice(AccountService accountService) {
        Account accounts = null;
        try {
            accounts = accountService.findAccount(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(getClass() + " --- " + accounts);
    }

    private void theAfterReturningAdvice(AccountService accountService) {
        List<Account> accounts = accountService.findAccounts();
        System.out.println(getClass() + " --- " + accounts);
    }

    private void theBeforeAdvice(AccountService accountService, MembershipService membershipService) {
        Account account = new Account("Lye", "Lie");
        accountService.addAccount(account, true);
        accountService.doWork();

        accountService.setName("Lye");
        accountService.setServiceCode("69");

        String name = accountService.getName();
        String serviceCde = accountService.getServiceCode();

        membershipService.addNewAccount();
    }
}
