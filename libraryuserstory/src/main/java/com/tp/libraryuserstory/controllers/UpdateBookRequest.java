package com.tp.libraryuserstory.controllers;

public class UpdateBookRequest {
    Integer bookID;
    Integer newID;
    String author;
    String newAuthor;
    String title;
    String newTitle;
    Integer newYear;

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
