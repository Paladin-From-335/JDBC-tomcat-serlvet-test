package com.github.books.utils;

import com.github.books.dto.AuthorIdRequest;
import com.github.books.dto.AuthorListIdDto;
import com.github.books.dto.ConnectInsertDto;
import com.github.books.entities.Author;
import com.github.books.entities.Book;
import com.github.orm.CustomRowMapper;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RowMappers {

    private static CustomRowMapper<Author> authorCustomRowMapper;

    private static CustomRowMapper<Book> bookCustomRowMapper;

    private static CustomRowMapper<ConnectInsertDto> connectInsertDtoCustomRowMapper;

    private static CustomRowMapper<AuthorListIdDto> authorListIdDtoCustomRowMapper;

    public static CustomRowMapper<Author> getAuthorCustomRowMapper (){
        if (authorCustomRowMapper == null) {
            authorCustomRowMapper = resultSet -> new Author(
                    resultSet.getLong("author_id"),
                    resultSet.getString("author_name")
            );
        }
        return authorCustomRowMapper;
    }

    public static CustomRowMapper<Book> getBookCustomRowMapper (){
        if (bookCustomRowMapper == null) {
            bookCustomRowMapper = resultSet -> new Book(
                    resultSet.getLong("book_id"),
                    resultSet.getString("book_name")
            );
        }
        return bookCustomRowMapper;
    }
    public static CustomRowMapper<ConnectInsertDto> getConnectionCustomRowMapper (){
        if (connectInsertDtoCustomRowMapper == null) {
            connectInsertDtoCustomRowMapper = resultSet -> new ConnectInsertDto(
                    resultSet.getLong("author_id"),
                    resultSet.getLong("book_id")
            );
        }
        return connectInsertDtoCustomRowMapper;
    }

    public static CustomRowMapper<AuthorListIdDto> getAuthorListIdDtoCustomRowMapper (){
        if (authorListIdDtoCustomRowMapper == null) {
            authorListIdDtoCustomRowMapper = resultSet -> new AuthorListIdDto(
                    List.of(resultSet.getLong("author_id"))
            );
        }
        return authorListIdDtoCustomRowMapper;
    }
}
