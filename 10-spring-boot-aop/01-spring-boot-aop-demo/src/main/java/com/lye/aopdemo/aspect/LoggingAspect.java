package com.lye.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//    @Before("execution(public void addAccount())")
//    @Before("execution(public void com.lye.aopdemo.repository.AccountRepository.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* com.lye.aopdemo.repository.*.add*(com.lye.aopdemo.model.Account, Boolean))")
//    @Before("execution(* com.lye.aopdemo.repository.*.add*(com.lye.aopdemo.model.Account, ..))")
//    @Before("execution(* com.lye.aopdemo.repository.*.add*(..))")
    @Before("execution(* com.lye.aopdemo.repository.*.*(..))")
    public void beforeAddAccount() {
        System.out.println(getClass() + "====> Executing @BeforeAdvice addAccount logging");
    }
}
