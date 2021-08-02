package com.github.books.controller;

import com.github.books.dto.AuthorDto;
import com.github.books.dto.BookDto;
import com.github.books.entities.Author;
import com.github.books.exceptions.BadRequest;
import com.github.books.services.AuthorService;

import java.util.List;

public class ControllerImpl {

    private final AuthorService authorService;

    public ControllerImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void createBook(BookDto payload) {
        if (payload.getBookName() == null || payload.getAuthorId() == null) {
            throw new BadRequest("Wrong book data");
        }
        this.authorService.insertBook(payload);
    }

    public void createAuthor(AuthorDto payload) {
        if (payload.getAuthorName() == null) {
            throw new BadRequest("Author must has name");
        }
        this.authorService.insertAuthor(payload);
    }

    public Author getAuthorById(Long id) {
        if (id < 1 || id.toString().equals("")) {
            throw new BadRequest("Wrong author id");
        }
        Author author = this.authorService.getAuthorById(id);
        if (author == null) {
            throw new BadRequest("Author with ID " + id + "is not exist");
        } else {
            return author;
        }
    }
    public List<Long> getAuthorIdByPartOfBookName (String bookName) {
        if(bookName == null) {
            throw new BadRequest("String is null");
        }
       return this.authorService.getAuthorIdByPartOfBookName(bookName);
    }
}
