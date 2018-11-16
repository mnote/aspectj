package io.github.mnote.jcabi;

import com.jcabi.aspects.Loggable;
import com.jcabi.aspects.RetryOnFailure;

import java.net.URL;

public class Resource {

    @Loggable(Loggable.DEBUG)
    @RetryOnFailure
    public String load(URL url) throws Exception {
        return String.valueOf(url.openConnection().getContent());
    }

}
