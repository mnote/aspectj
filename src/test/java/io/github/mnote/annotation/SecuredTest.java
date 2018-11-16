package io.github.mnote.annotation;

import org.junit.Test;

public class SecuredTest {

    @Test
    public void testMethod() throws Exception {
        SecuredMethod service = new SecuredMethod();
        service.unlockedMethod();
        service.lockedMethod();
    }

}
