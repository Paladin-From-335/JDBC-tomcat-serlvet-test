package com.github.books.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class AuthorDto {

    @JsonProperty("author_name")
    private String authorName;

    public AuthorDto() {
    }

    public AuthorDto(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDto authorDto = (AuthorDto) o;
        return Objects.equals(authorName, authorDto.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorName);
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "authorName='" + authorName + '\'' +
                '}';
    }
}
