package com.miu.waa.assignment6.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LogAspect {

    private static int TransactionId = 1;
    @Pointcut("execution( * com.miu.waa.assignment5.controller.*.*(..))")
    public void log() {
    }

    @After("log()")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Log after the method: " + methodName);
        // fake logging to console instead of DB
        System.out.println(TransactionId++ + ", " + LocalDateTime.now() + ", Sushanta, " + methodName);
    }

}
