package com.example.aspectos.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Pointcut("execution(* com.example.aspectos.services.GreetingService.*(..))")
  private void greetingLoggerPonitcut() {

  }

  @Before("greetingLoggerPonitcut")
  public void loggerBefore(JoinPoint joinPoint) {

    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("Antes: " + method + " con los argumentos " + args);
  }

  @After("greetingLoggerPonitcut")
  public void loggerAfter(JoinPoint joinPoint) {

    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("Despues: " + method + " con los argumentos " + args);
  }

  @AfterReturning("greetingLoggerPonitcut")
  public void loggerAfterReturning(JoinPoint joinPoint) {

    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("Despues de retornar: " + method + " con los argumentos " + args);
  }

  @AfterThrowing("greetingLoggerPonitcut")
  public void loggerAfterThrowing(JoinPoint joinPoint) {

    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    logger.info("Despues de lanzar la excepcion: " + method + " con los argumentos " + args);
  }

  @Around("greetingLoggerPonitcut")
  public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {

    String method = joinPoint.getSignature().getName();
    String args = Arrays.toString(joinPoint.getArgs());

    Object result = null;

    try {

      // antes de ejecutar el metodo observado @Before

      logger.info("metodo before: " + method + " con los argumentos " + args);

      result = joinPoint.proceed(); // aqui ejecuta el metodo observado

      // despues de ejecutar el metodo observado @After
      logger.info("metodo after: " + method + " con los argumentos " + args);

    } catch (Throwable e) {

      // en caso de que se lance una excepcion @AfterThrowing
      logger.error("Error en el metodo: " + method + " con los argumentos " + args);
      throw e;
    }

    return result;
  }

}
