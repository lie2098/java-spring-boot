package com.lye.aopdemo;

import com.lye.aopdemo.model.Account;
import com.lye.aopdemo.service.AccountService;
import com.lye.aopdemo.service.MembershipService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean

    public CommandLineRunner commandLineRunner(AccountService accountService,
                                               MembershipService membershipService) {
        return runner -> {
            theBeforeAdvice(accountService, membershipService);

        };
    }

    private void theBeforeAdvice(AccountService accountService, MembershipService membershipService) {
        Account account = new Account("Lye", "Lie");
        accountService.addAccount(account, true);
        accountService.doWork();
        membershipService.addNewAccount();
    }
}
