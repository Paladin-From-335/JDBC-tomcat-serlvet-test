package com.github.books.configs;

import com.github.books.repo.RepoImpl;
import com.github.books.services.AuthorService;
import com.github.orm.CustomJdbc;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DatabaseConfig {

    private static final String HIKARI_PROPERTY_PATH = "/configdb.properties";

    public static DataSource getHikariDS() {
        HikariConfig config = new HikariConfig(HIKARI_PROPERTY_PATH);
        return new HikariDataSource(config);
    }

    public static RepoImpl getRepo() {
        return new RepoImpl(new CustomJdbc(getHikariDS()));
    }

    public static AuthorService getService() {
        return new AuthorService(getRepo());
    }
}
