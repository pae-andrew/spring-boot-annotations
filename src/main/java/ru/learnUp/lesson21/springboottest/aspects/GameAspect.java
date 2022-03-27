package ru.learnUp.lesson21.springboottest.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GameAspect {

    private static final Logger log = LoggerFactory.getLogger(GameAspect.class);

    @Pointcut("@annotation(ru.learnUp.lesson21.springboottest.aspects.LogMethod)")
    public void callInLogMethodPath() {}

    @Pointcut("@annotation(ru.learnUp.lesson21.springboottest.aspects.WorkTime)")
    public void callInWorkTimePath() {}

    @Around("callInLogMethodPath()")
    public void aroundLogMethodPathAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("name: {}", joinPoint.getSignature().getName());
        for (Object arg : joinPoint.getArgs()) {
            log.info("arg: {}", arg);
        }
        if (joinPoint.getArgs().length == 0) {
            log.info("there's no arguments");
        }
        log.info("return value: {}", joinPoint.proceed());
    }

    @Around("callInWorkTimePath()")
    public Object aroundWorkTimeAnnotation(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("name: {}", joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long finish = System.currentTimeMillis();
        log.info("running time of this method: {} ms", finish - start);
        return result;
    }

}
