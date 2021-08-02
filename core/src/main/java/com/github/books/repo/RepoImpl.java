package com.github.books.repo;

import com.github.books.dto.AuthorListIdDto;
import com.github.books.dto.ConnectInsertDto;
import com.github.books.entities.Author;
import com.github.books.entities.Book;
import com.github.books.utils.RowMappers;
import com.github.orm.CustomJdbc;

public class RepoImpl implements Repo {

    private final CustomJdbc customJdbc;

    public RepoImpl(CustomJdbc customJdbc) {
        this.customJdbc = customJdbc;
    }


    @Override
    public Author findAuthorById(Long id) {
        return customJdbc.findBy(
                "SELECT * FROM author_table WHERE author_id = ?",
                RowMappers.getAuthorCustomRowMapper(),
                id
        );
    }

    @Override
    public Book findBookByName(String name) {
        return customJdbc.findBy(
                "SELECT * FROM book_table WHERE book_name = ?",
                RowMappers.getBookCustomRowMapper(),
                name
        );
    }

    @Override
    public AuthorListIdDto findAuthorByPartOfBookName(String partOfName) {
        return (AuthorListIdDto) customJdbc.findAll(
                "SELECT a.author_id FROM author_table a inner join connect_table ct on a.author_id = ct.author_id inner join book_table bt on bt.book_id = ct.book_id WHERE bt.book_name LIKE '%" + partOfName + "%'",
                RowMappers.getAuthorListIdDtoCustomRowMapper(),
                partOfName
        );
    }

    @Override
    public Author saveAuthor(Author entity) {
        return customJdbc.insert(
                "INSERT INTO author_table (author_name) VALUES(?)",
                RowMappers.getAuthorCustomRowMapper(),
                entity.getAuthorName()
        );
    }

    @Override
    public Book saveBook(Book entity) {
        return customJdbc.insert(
                "INSERT INTO book_table (book_name) VALUES(?)",
                RowMappers.getBookCustomRowMapper(),
                entity.getBookName()
        );
    }

    @Override
    public ConnectInsertDto saveToConnect(ConnectInsertDto entity) {
        return customJdbc.insert(
                "INSERT INTO connect_table (author_id, book_id) VALUES(?,?)",
                RowMappers.getConnectionCustomRowMapper(),
                entity.getAuthorId(),
                entity.getBookId()
        );
    }

    @Override
    public void update(Author entity) {

    }
}
