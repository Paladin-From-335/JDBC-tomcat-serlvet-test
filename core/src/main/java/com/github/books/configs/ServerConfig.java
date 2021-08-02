package com.github.books.configs;

import com.github.books.handlers.HttpHandler;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class ServerConfig {

    public static ServerRunner tomcat() throws ServletException, LifecycleException {
        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8084";
        }
        tomcat.setPort(Integer.parseInt(webPort));
        Context ctx = tomcat.addWebapp("/", new File(".").getAbsolutePath());
        tomcat.addServlet(ctx, HttpHandler.class.getName(), HandlerConfig.getHandler()).setAsyncSupported(true);
        ctx.addServletMappingDecoded("/*", HttpHandler.class.getName());
        return new ServerRunner(tomcat, ctx);
    }

}
