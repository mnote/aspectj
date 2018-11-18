package io.github.mnote.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@SuppressWarnings("SpringAopErrorsInspection")
@Aspect
public class SecuredMethodTestAspect {

    @Before("call(@io.github.mnote.annotation.Secured public * io.github.mnote.annotation.SecuredMethod.*(..)) && within(io.github.mnote.annotation.*) && this(caller) && target(callee)")
    public void before(SecuredMethodTest caller, SecuredMethod callee) throws Throwable {
        System.out.println("caller: " + caller + ", callee: " + callee);
    }

}
