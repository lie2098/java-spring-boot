package com.lye.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

    @Pointcut("execution(* com.lye.aopdemo.repository.*.*(..))")
    private void repositoryPkg() {
    }

    @Pointcut("execution(* com.lye.aopdemo.repository.*.add*(..))")
    private void add() {
    }

    @Pointcut("execution(* com.lye.aopdemo.repository.*.get*())")
    private void getter() {
    }

    @Pointcut("execution(* com.lye.aopdemo.repository.*.set*(*))")
    private void setter() {
    }

    @Pointcut("getter() || setter()")
    private void getterAndSetter() {
    }

    @Pointcut("repositoryPkg() && !(getterAndSetter())")
    protected void repositoryPkgAndNoSetterAndGetter() {
    }

    @Pointcut("repositoryPkg() && !(getterAndSetter()) && add()")
    protected void repositoryPkgAndNoSetterAndGetterAdd() {}

    @Pointcut("execution(* find*())")
    private void find() {
    }

    @Pointcut("repositoryPkg() && find()")
    protected void repoFind() {
    }
}
