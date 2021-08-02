package com.github.books.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class BookDto {

    @JsonProperty("book_name")
    private String bookName;

    @JsonProperty("authors")
    private List<Long> authorId;

    public BookDto() {
    }

    public BookDto(String bookName, List<Long> authorId) {
        this.bookName = bookName;
        this.authorId = authorId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Long> getAuthorId() {
        return authorId;
    }

    public void setAuthorId(List<Long> authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(bookName, bookDto.bookName) && Objects.equals(authorId, bookDto.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, authorId);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bookName='" + bookName + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
