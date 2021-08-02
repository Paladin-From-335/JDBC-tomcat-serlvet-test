package com.github.books.utils;

import com.github.books.dto.AuthorDto;
import com.github.books.dto.BookDto;
import com.github.books.entities.Author;
import com.github.books.entities.Book;

public class TransferObj {

    public static Author toAuthor(AuthorDto payload) {
        return new Author(
                payload.getAuthorName()
        );
    }

    public static Book toBook(BookDto bookDto) {
        return new Book(
                bookDto.getBookName().trim()
        );
    }
}
