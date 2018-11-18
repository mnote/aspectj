package io.github.mnote.annotation;

import org.junit.Test;

import java.math.BigDecimal;

public class SecuredMethodTest {

    @Test
    public void testMethod() throws Exception {
        SecuredMethod service = new SecuredMethod();
        service.unlockedMethod();
        service.lockedMethod();
        service.paramMethod(BigDecimal.valueOf(-12.222));
    }

}
