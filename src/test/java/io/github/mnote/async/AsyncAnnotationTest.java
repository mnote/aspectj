package io.github.mnote.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AsyncAnnotationTest {

    @Resource
    private AsyncAnnotation asyncAnnotation;

    @Test
    public void sync() throws InterruptedException, ExecutionException {

        System.out.println("Invoking an asynchronous method. " + Thread.currentThread().getName());

        Future<String> future = asyncAnnotation.async();

        while (true) {
            if (future.isDone()) {
                System.out.println("Result from asynchronous process - " + future.get());
                break;
            }
            System.out.println("Continue doing something else. ");
            Thread.sleep(5000);
        }
    }

}
