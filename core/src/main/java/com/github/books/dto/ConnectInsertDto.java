package com.github.books.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ConnectInsertDto {

    @JsonProperty("author_id")
    private Long authorId;

    @JsonProperty("book_id")
    private Long bookId;

    public ConnectInsertDto() {
    }

    public ConnectInsertDto(Long authorId, Long bookId) {
        this.authorId = authorId;
        this.bookId = bookId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectInsertDto that = (ConnectInsertDto) o;
        return Objects.equals(authorId, that.authorId) && Objects.equals(bookId, that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, bookId);
    }

    @Override
    public String toString() {
        return "ConnectInsertDto{" +
                "authorId='" + authorId + '\'' +
                ", bookId='" + bookId + '\'' +
                '}';
    }
}
