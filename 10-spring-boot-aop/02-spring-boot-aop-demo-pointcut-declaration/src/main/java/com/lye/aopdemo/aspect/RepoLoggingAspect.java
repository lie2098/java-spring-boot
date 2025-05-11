package com.lye.aopdemo.aspect;

import com.lye.aopdemo.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
}
