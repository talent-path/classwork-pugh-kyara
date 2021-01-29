package com.tp.libraryuserstory.controllers;

import java.util.List;

public class UpdateBookRequest {
    Integer bookID;
    Integer newID;
    String author;
    String newAuthor;
    String title;
    String newTitle;
    Integer newYear;
    List<String> authorsList;
    List<String> newAuthList;

    public List<String> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<String> authorsList) {
        this.authorsList = authorsList;
    }

    public List<String> getNewAuthList() {
        return newAuthList;
    }

    public void setNewAuthList(List<String> newAuthList) {
        this.newAuthList = newAuthList;
    }

    public Integer getNewID() {
        return newID;
    }

    public void setNewID(Integer newID) {
        this.newID = newID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getNewAuthor() {
        return newAuthor;
    }

    public void setNewAuthor(String newAuthor) {
        this.newAuthor = newAuthor;
    }

    public Integer getNewYear() {
        return newYear;
    }

    public void setNewYear(Integer newYear) {
        this.newYear = newYear;
    }
}
