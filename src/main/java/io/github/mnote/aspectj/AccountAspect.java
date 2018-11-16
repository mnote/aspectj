package io.github.mnote.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * AspectJ 5 also supports an annotation-based style of aspect declaration, @AspectJ annotations
 */
@Aspect
public class AccountAspect {

    @Pointcut(value = "execution(* io.github.mnote.aspectj.Account.*draw(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object returnValue = proceedingJoinPoint.proceed();

        String methodName = proceedingJoinPoint.getSignature().getName();

        System.out.println(AccountAspect.class.getName() + ": " + methodName + ", " + returnValue);

        return returnValue;
    }

    @AfterThrowing(throwing = "e", pointcut = "pointCut()", argNames = "e,joinPoint")
    public void doAfterThrowing(Throwable e, JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(AccountAspect.class.getName() + ": " + methodName);
    }

}
