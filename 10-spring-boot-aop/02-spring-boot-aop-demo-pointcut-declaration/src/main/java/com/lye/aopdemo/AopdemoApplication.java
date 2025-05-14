package com.lye.aopdemo;

import com.lye.aopdemo.model.Account;
import com.lye.aopdemo.service.AccountService;
import com.lye.aopdemo.service.MembershipService;
import com.lye.aopdemo.service.TrafficFortuneService;
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
                                               MembershipService membershipService,
                                               TrafficFortuneService trafficFortuneService) {
        return runner -> {
//            System.out.println("=== Before Advice ===");
//            theBeforeAdvice(accountService, membershipService);
//
//            System.out.println("\n=== After Return Advice ===");
//            theAfterReturningAdvice(accountService);
//
//            System.out.println("\n=== After Return Throwing Advice ===");
//            theAfterThrowingAdvice(accountService);
//
//            System.out.println("\n=== After Finally Advice ===");
//            theAfterAdvice(accountService);

//            System.out.println("\n=== Around Advice ===");
//            theAroundAdvice(trafficFortuneService);

//            System.out.println("\n=== Around Advice HandleException ===");
//            theAroundAdviceHandleException(trafficFortuneService);

            System.out.println("\n=== Around Advice RethrowException ===");
            theAroundAdviceRethrowException(trafficFortuneService);
        };
    }

    private void theAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
        trafficFortuneService.setFortune("theAroundAdviceHandleException!");
        try {
            System.out.println("Your Fortune: " + trafficFortuneService.fortuneToday(true, true));
        } catch (Exception e) {
            System.out.println("Your Fortune: " + e.getMessage());
        }
    }

    private void theAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
        trafficFortuneService.setFortune("theAroundAdviceHandleException!");
        System.out.println("Your Fortune: " + trafficFortuneService.fortuneToday(true, false));
    }

    private void theAroundAdvice(TrafficFortuneService trafficFortuneService) {
        trafficFortuneService.setFortune("What a Blast!");
        System.out.println("Your Fortune: " + trafficFortuneService.fortuneToday());
    }

    private void theAfterAdvice(AccountService accountService) {
        findAccount(accountService, true);
    }

    private void theAfterThrowingAdvice(AccountService accountService) {
        findAccount(accountService, false);
    }

    private void findAccount(AccountService accountService, boolean flag) {
        Account accounts = null;
        try {
            accounts = accountService.findAccount(flag);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(" --- " + accounts);
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
