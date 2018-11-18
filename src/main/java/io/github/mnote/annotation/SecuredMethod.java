package io.github.mnote.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class SecuredMethod {

    private static final Logger logger = LoggerFactory.getLogger(SecuredMethod.class);

    @Secured(isLocked = true)
    //@Loggable(Loggable.WARN)
    public void lockedMethod() {
        logger.info("lockedMethod called");
    }

    @Secured(isLocked = false)
    //@Loggable(Loggable.WARN)
    public void unlockedMethod() {
        logger.info("unlockedMethod called");
    }

    @Secured(isLocked = false)
    public BigDecimal paramMethod(BigDecimal decimal) {
        logger.info("paramMethod called:" + decimal);
        return decimal.abs();
    }

}
