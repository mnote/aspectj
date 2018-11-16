package io.github.mnote.annotation;

public class SecuredMethod {

    @Secured(isLocked = true)
    public void lockedMethod() {
    }

    @Secured(isLocked = false)
    public void unlockedMethod() {
    }

}
