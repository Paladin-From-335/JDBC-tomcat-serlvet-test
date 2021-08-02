package com.github.books.configs;

import com.github.books.handlers.HttpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandlerConfig {

    Logger log = LoggerFactory.getLogger(HandlerConfig.class);

    private static final HttpHandler handler = new HttpHandler(ControllerConfig.getController());

    public static HttpHandler getHandler() {
        return handler;
    }
}
