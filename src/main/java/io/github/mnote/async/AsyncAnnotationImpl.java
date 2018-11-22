package io.github.mnote.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncAnnotationImpl implements AsyncAnnotation{

    @Async
    public void asyncVoid() {
        System.out.println("Execute method asynchronously. " + Thread.currentThread().getName());
    }

    @Async
    public Future<String> async() {

        //Thread.dumpStack();

        //org.springframework.aop.interceptor.AsyncExecutionInterceptor$1.call(AsyncExecutionInterceptor.java:115)

        System.out.println("Execute method asynchronously - " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<String>("hello world !!!!");
        } catch (InterruptedException e) {
            //
        }

        return null;
    }

}
