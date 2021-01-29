package com.tp.libraryuserstory.models;

import java.util.ArrayList;
import java.util.List;

public class LibraryApp {
    //in our library we have a book
    //those books contain these variables
    private Integer bookID;
    private String title;
    private Integer year;


    //can have more than one author
    private List<String> authors;


    //adding a new book to the library;
    //must have at the very least an ID the other variables initialized to default values
    public LibraryApp(Integer bookID, String title, String author)

    {
        this.bookID = bookID;
        this.title = title;
        this.year = 0;
        this.authors = new ArrayList<>();
        authors.add(author);
    }

    //to update or add to an existing book
    public LibraryApp(Integer bookID, String title, List<String> authors, Integer year)
    {
        this.bookID = bookID;
        this.title = title;
        this.year = year;
        this.authors = authors;


    }

    //copy constructor
    public LibraryApp (LibraryApp that) {
        this.bookID = that.bookID;
        this.title = that.title;
        this.year = that.year;
        for (String copyAuthors : that.authors) {
            this.authors.add(copyAuthors);
        }
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

}
