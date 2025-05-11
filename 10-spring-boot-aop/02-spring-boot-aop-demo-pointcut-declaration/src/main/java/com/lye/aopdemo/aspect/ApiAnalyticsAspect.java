package com.lye.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class ApiAnalyticsAspect extends AopExpressions{

    @Before("repositoryPkgAndNoSetterAndGetter()")
    public void performApiAnalytics() {
        System.out.println(getClass() + "====> Executing @BeforeAdvice PerformApiAnalytics");
    }
}
