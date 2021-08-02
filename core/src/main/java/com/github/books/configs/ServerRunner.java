package com.github.books.configs;

import com.github.books.controller.ControllerImpl;
import com.github.books.handlers.HttpHandler;
import com.github.books.repo.RepoImpl;
import com.github.books.services.AuthorService;
import com.github.orm.CustomJdbc;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerRunner {

    Logger logger = LoggerFactory.getLogger(ServerRunner.class);

    private static HttpHandler httpHandler = new HttpHandler(new ControllerImpl(new AuthorService(new RepoImpl(new CustomJdbc(new HikariDataSource())))));

    private final Tomcat tomcat;

    private final Context ctx;


    public ServerRunner(Tomcat tomcat, Context ctx) {
        this.tomcat = tomcat;
        this.ctx = ctx;
    }

    public void run() {
        try {
            this.tomcat.start();
            this.tomcat.getServer().await();
        } catch (LifecycleException e) {
            logger.warn("Enter {}", e.getMessage());
        }
    }

//    public static void run() {
//        Tomcat tomcat = new Tomcat();
//        String port = System.getenv("PORT");
//        if(port == null || port.isEmpty()){
//            port = "8084";
//        }
//        tomcat.setPort(8084);
//        try {
//            tomcat.addWebapp("", "C:\\Users\\goods\\Desktop\\github\\ukrpochta\\core\\web");
//            tomcat.start();
//        } catch (ServletException | LifecycleException e) {
//            e.printStackTrace();
//        }
//        tomcat.getServer().await();
//    }
}
