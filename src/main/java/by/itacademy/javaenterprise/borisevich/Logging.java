package by.itacademy.javaenterprise.borisevich;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class Logging {

    @Pointcut("execution(* by.itacademy.javaenterprise.borisevich.Developer.throwSomeMysticException())")
    public void methodWithoutArguments() {
    }

    @Before("methodWithoutArguments()")
    public void beforeAdvice() {
        log.info("Now we are going to initiate developer's profile.");
    }

    @After("methodWithoutArguments()")
    public void afterAdvice() {
        log.info("Developer's profile has been initiated.");
    }

    @AfterThrowing(pointcut = "methodWithoutArguments()", throwing = "e")
    public void inCaseOfExceptionThrowAdvice(ClassCastException e) {
        log.error("We have an exception here: " + e.toString());
    }

    @Pointcut("execution(public String by.itacademy.javaenterprise.borisevich.Developer.doSomeCode(Integer, Integer, Integer))")
    public void methodWithArguments() {
    }

    @Around("methodWithArguments()")
    public void aroundMethodWithArguments(ProceedingJoinPoint joinPoint) {
        try {
            log.info("Start");
            long start = System.currentTimeMillis();
            log.info("Begin time: " + start);
            Object result = joinPoint.proceed();
            long finish = System.currentTimeMillis();
            log.info("Finish time: " + finish);
            long time = finish - start;
            log.info("Total time: " + time);
            log.info("ResultOfMethodWithArguments: " + result);
        } catch (Throwable throwable) {
            log.info(throwable.toString());
        }
    }

    @Pointcut("execution(* by.itacademy.javaenterprise.borisevich.Developer.initProfile())")
    public void initializeMethod() {
    }
    @Before("initializeMethod()")
    public void beforeInitializeMethod() {
        log.info("Now we are going to initiate developer's profile.");
    }

    @AfterReturning(pointcut = "initializeMethod()", returning = "someValue")
    public void afterReturningAdvice(Object someValue) {
        log.info("Value: " + someValue.toString());
    }

}
