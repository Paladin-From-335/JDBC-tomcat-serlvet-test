package com.github.books.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class AuthorIdRequest {

    @JsonProperty("author_id")
    private Long authorId;

    public AuthorIdRequest() {
    }

    public AuthorIdRequest(Long authorId) {
        this.authorId = authorId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorIdRequest that = (AuthorIdRequest) o;
        return Objects.equals(authorId, that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId);
    }

    @Override
    public String toString() {
        return "AuthorIdRequest{" +
                "authorId=" + authorId +
                '}';
    }
}
