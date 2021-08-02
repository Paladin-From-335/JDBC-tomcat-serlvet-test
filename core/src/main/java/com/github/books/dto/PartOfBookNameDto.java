package com.github.books.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PartOfBookNameDto {

    @JsonProperty("part_book_name")
    private String bookName;

    public PartOfBookNameDto() {
    }

    public PartOfBookNameDto(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartOfBookNameDto that = (PartOfBookNameDto) o;
        return Objects.equals(bookName, that.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName);
    }

    @Override
    public String toString() {
        return "PartOfBookNameDto{" +
                "bookName='" + bookName + '\'' +
                '}';
    }
}
