package com.lye.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class CloudLogAsyncAspect extends AopExpressions {

    @Before("repositoryPkgAndNoSetterAndGetter()")
    public void logToCloudAsync() {
        System.out.println();
        System.out.println(getClass() + "====> Executing @BeforeAdvice LogToCloudAsync");
    }
}
