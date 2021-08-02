package com.github.books.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Author {

    @JsonProperty("author_id")
    private long authorId;

    @JsonProperty("author_name")
    private String authorName;

    public Author() {
    }

    public Author(long authorId) {
        this.authorId = authorId;
    }

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public Author(long authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
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
        Author author = (Author) o;
        return authorId == author.authorId && Objects.equals(authorName, author.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorName);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
