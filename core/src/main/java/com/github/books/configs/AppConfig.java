package com.github.books.configs;

import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

public class AppConfig {

    public static void startTomcat() {
        try {
            ServerConfig.tomcat().run();
        } catch (ServletException | LifecycleException e) {
            e.printStackTrace();
        }

    }
}
