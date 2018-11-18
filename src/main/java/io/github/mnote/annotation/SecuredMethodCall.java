package io.github.mnote.annotation;

import com.jcabi.aspects.Loggable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecuredMethodCall {

    //init logging for @Loggable
    private static final Logger logger = LoggerFactory.getLogger(SecuredMethodCall.class);

    public static void main(String[] args) {
        new SecuredMethodCall().test();
        logger.info("main");
    }

    @Loggable
    public void test(){
        SecuredMethod service = new SecuredMethod();
        service.lockedMethod();
        service.unlockedMethod();
    }
}
