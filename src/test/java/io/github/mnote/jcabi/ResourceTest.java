package io.github.mnote.jcabi;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;

public class ResourceTest {

    private Resource resource;

    @Before
    public void before(){
        resource = new Resource();
    }

    @Test
    public void load() throws Exception {

        String string = resource.load(new URL("http://www.dict.cn/"));

        System.out.println(string);

    }

}
