package ru.sberbank;

import org.apache.log4j.EnhancedThrowableRenderer;
import org.apache.log4j.spi.ThrowableRenderer;

import static java.lang.String.join;

public class LogThrowableRenderer implements ThrowableRenderer {

    EnhancedThrowableRenderer renderer = new EnhancedThrowableRenderer();
//    DefaultThrowableRenderer renderer = new DefaultThrowableRenderer();

    @Override
    public String[] doRender(Throwable t) {
        String[] output = new String[1];
        output[0] = join(" -->", renderer.doRender(t)).replaceAll("null", "");
        return output;
    }
}
