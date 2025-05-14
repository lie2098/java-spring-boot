package com.lye.aopdemo.aspect;

import com.lye.aopdemo.model.Account;
import com.lye.aopdemo.service.TrafficFortuneService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;

@Aspect
@Order(2)
@Component
public class RepoLoggingAspect extends AopExpressions {

    @Before("repositoryPkgAndNoSetterAndGetterAdd()")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println(getClass() + "====> Executing @BeforeAdvice addAccount logging");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + signature);

        Object[] args = joinPoint.getArgs();
        System.out.println("args: " + Arrays.toString(args));

        if (!ObjectUtils.isEmpty(args) && args[0] instanceof Account newAcc) {
            newAcc.setName(newAcc.getName() + " testo");
        }
    }

    @AfterReturning(pointcut = "repoFind()", returning = "res")
    public void afterReturningFindAccounts(JoinPoint joinPoint, List<Account> res) {
        System.out.println("\n=====> @AfterReturning" + joinPoint.getSignature().toShortString());
        System.out.println("=====> @AfterReturning " + res);

        if (!ObjectUtils.isEmpty(res)) {
            String name = res.get(0).getName();
            res.get(0).setName(name + " afterReturndesu");

            res.forEach(
                    item -> item.setName(item.getName().toUpperCase())
            );
        }
    }

    @AfterThrowing(pointcut = "repoFind()", throwing = "ex")
    public void afterThrowingFindAccounts(JoinPoint joinPoint, Exception ex) {
        System.out.println("\n=====> @AfterThrowing " + joinPoint.getSignature().toShortString());
        System.out.println("=====> @AfterThrowing Exception: " + ex);
    }

    @After("repoFind()")
    public void afterFinallyFindAccounts(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("=====> @After Finally Method: " + method);
    }

    @Around("fortuneGetTodayFortune()")
    public Object aroundFortune(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
        long startTime = System.nanoTime();

        Object res = null;

        try {
            res = joinPoint.proceed();
        } catch (Exception e) {
            System.out.println("exception message: " + e.getMessage());
            res = "You have bad fortune today! Be careful!";

            Object[] args = joinPoint.getArgs();
            //rethrow exception
            if (!ObjectUtils.isEmpty(args) && args[1] instanceof Boolean && (Boolean) args[1]) {
                throw e;
            }
        }

//        long endTime = System.currentTimeMillis();
        long endTime = System.nanoTime();

        System.out.println("=====> Around Method: " + joinPoint.getSignature().toShortString());
//        System.out.println("=====> processed time: " + ((endTime - startTime) / 1000) + " seconds");
        System.out.println("=====> processed time: " + (endTime - startTime) + " nanoseconds");

        return res;
    }

    @Around("fortuneSetFortune()")
    public Object beforeSetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("=====> Before SetFortune: " + joinPoint.getSignature().toShortString());
        Object[] args = joinPoint.getArgs();

        if (!ObjectUtils.isEmpty(args) && args[0] instanceof String) {
            args[0] = "Today's Fortune is " + args[0];
        }

        return joinPoint.proceed(args);
    }
}
