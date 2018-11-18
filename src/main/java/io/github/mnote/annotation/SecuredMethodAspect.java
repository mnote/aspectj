package io.github.mnote.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@SuppressWarnings("SpringAopErrorsInspection")
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

    @Before("call(@io.github.mnote.annotation.Secured public * io.github.mnote.annotation.SecuredMethod.*(..)) && within(io.github.mnote.annotation.*) && this(caller) && target(callee)")
    public void call(SecuredMethodCall caller, SecuredMethod callee) throws Throwable {
        System.out.println("caller: " + caller + ", callee: " + callee);
    }

}
