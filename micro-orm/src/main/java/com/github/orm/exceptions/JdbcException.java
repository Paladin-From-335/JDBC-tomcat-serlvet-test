package com.github.orm.exceptions;

public class JdbcException extends RuntimeException{

    public JdbcException() {
    }

    public JdbcException(String message) {
        super(message);
    }
}
