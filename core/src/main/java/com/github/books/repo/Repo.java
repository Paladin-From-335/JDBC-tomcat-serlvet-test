package com.github.books.repo;

import com.github.books.dto.AuthorListIdDto;
import com.github.books.dto.ConnectInsertDto;
import com.github.books.entities.Author;
import com.github.books.entities.Book;

public interface Repo {

    Author findAuthorById(Long id);

    Book findBookByName(String name);

    AuthorListIdDto findAuthorByPartOfBookName(String partOfName);

    Author saveAuthor(Author entity);

    Book saveBook(Book entity);

    ConnectInsertDto saveToConnect(ConnectInsertDto payload);

    void update(Author entity);

}
