package io.github.mnote.async;

import java.util.concurrent.Future;

/**
 * https://www.baeldung.com/spring-async
 */
public interface AsyncAnnotation {

    void asyncVoid();

    Future<String> async();

}
