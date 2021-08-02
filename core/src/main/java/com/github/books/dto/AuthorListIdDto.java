package com.github.books.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class AuthorListIdDto {

    @JsonProperty("author_id")
    private List<Long> authorId;

    public AuthorListIdDto() {
    }

    public AuthorListIdDto(List<Long> authorId) {
        this.authorId = authorId;
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
        AuthorListIdDto that = (AuthorListIdDto) o;
        return Objects.equals(authorId, that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId);
    }

    @Override
    public String toString() {
        return "AuthorListIdDto{" +
                "authorId=" + authorId +
                '}';
    }
}
