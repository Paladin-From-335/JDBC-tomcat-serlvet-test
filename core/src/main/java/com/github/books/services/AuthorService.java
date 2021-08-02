package com.github.books.services;

import com.github.books.dto.AuthorDto;
import com.github.books.dto.BookDto;
import com.github.books.dto.ConnectInsertDto;
import com.github.books.entities.Author;
import com.github.books.entities.Book;
import com.github.books.repo.Repo;
import com.github.books.utils.TransferObj;

import java.util.List;

public class AuthorService {

    private final Repo repo;

    public AuthorService(Repo repo) {
        this.repo = repo;
    }

    public void insertAuthor(AuthorDto payload) {
        Author author = TransferObj.toAuthor(payload);
        repo.saveAuthor(author);
    }

    public void insertBook(BookDto payload) {
        Book book = TransferObj.toBook(payload);
        repo.saveBook(book);
        this.insertIntoConnection(payload);
    }

    public void insertIntoConnection(BookDto payload) {
        ConnectInsertDto connectInsertDto = new ConnectInsertDto();
        Long bookId = repo.findBookByName(payload.getBookName()).getBookId();
        for (int i = 0; i < payload.getAuthorId().size(); i++) {
            connectInsertDto.setBookId(bookId);
            connectInsertDto.setAuthorId(payload.getAuthorId().get(i));
            repo.saveToConnect(connectInsertDto);
        }
    }

    public Author getAuthorById(Long id) {
        return repo.findAuthorById(id);
    }

    public List<Long> getAuthorIdByPartOfBookName(String bookName) {
       return (List<Long>)repo.findAuthorByPartOfBookName(bookName);
    }
}
