package io.github.mnote.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecuredMethodAspect {

    @Pointcut("@annotation(secured)")
    public void pointCut(Secured secured) {
    }

    @Around("pointCut(secured)")
    public Object around(ProceedingJoinPoint pjp, Secured secured) throws Throwable {
        System.out.println(pjp + ", " + secured.isLocked());
        return secured.isLocked() ? null : pjp.proceed();
    }

}
