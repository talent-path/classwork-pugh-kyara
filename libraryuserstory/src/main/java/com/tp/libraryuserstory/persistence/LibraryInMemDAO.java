package com.tp.libraryuserstory.persistence;

import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.models.LibraryApp;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryInMemDAO implements LibraryDAO {

    private List<LibraryApp> fullCollection = new ArrayList<>();

    public LibraryInMemDAO()
    {
       LibraryApp firstBook = new LibraryApp(100, "My Book", "Jane Doe");
       fullCollection.add(firstBook);
    }


    //create a new book
    @Override
    public int createBook(String title, String author) throws NullAuthorException, NullTitleException {
        if(title == null)
        {
            throw new NullTitleException("Cannot add a book with a null title!");
        }
        if(author == null)
        {
            throw new NullAuthorException("Cannot add a book with a null author!");
        }
        int id = 0;
        for(LibraryApp toCheck : fullCollection )
        {
            if(toCheck.getBookID()>id)
            {
                id = toCheck.getBookID();
            }
        }
        id++;
        LibraryApp bookToAdd = new LibraryApp(id,title,author);
        fullCollection.add(bookToAdd);
        return id;
    }

    //returns a specific book
    @Override
    public LibraryApp getBookByID(Integer bookID) {
        LibraryApp toReturn = null;

        for(LibraryApp toCheck : fullCollection)
        {
            if(toCheck.getBookID().equals(bookID))
            {
                toReturn = new LibraryApp(toCheck);
                break;
            }
        }
        return toReturn;
    }

    //returns full library collection
    @Override
    public List<LibraryApp> getCollection() {
        List<LibraryApp> copyCollection = new ArrayList<>();
        for(LibraryApp toCopy : fullCollection)
        {
            copyCollection.add(new LibraryApp(toCopy));
        }
        return copyCollection;
    }


    //returns a list of authors
    //TODO:create a way to iterate through author list
    @Override
    public List<String> getAuthorList() {
        List<LibraryApp> copyCollection = new ArrayList<>();
        List<String> copyAuthorList = new ArrayList<>();
        for(LibraryApp toCopy : fullCollection)
        {
         for(String copyAuthor : toCopy.getAuthors())
         {
             copyAuthorList.add(copyAuthor);
         }
        }

        return copyAuthorList;
    }

    @Override
    public LibraryApp getBookByAuthor(String author) throws NullAuthorException {
        LibraryApp toReturn = null;
        for(LibraryApp toCheck : fullCollection)
        {
            if(toCheck.getAuthors().equals(author))
            {
                toReturn = new LibraryApp(toCheck);
                break;
            }
        }
        return toReturn;
    }

    //edit a book ID given a specific ID
    @Override
    public void editBookID(LibraryApp app, Integer newID) throws InvalidBookIDException{
        int editIndex = -1;
        for (int i = 0; i < fullCollection.size(); i++) {
            if(fullCollection.get(i).getBookID().equals(app.getBookID()))
            {
                fullCollection.get(i).setBookID(newID);
                break;
            }
            else
            {
                throw new InvalidBookIDException("Could not find a book with the ID "+ app.getBookID());
            }
        }

    }

    //edits a book title given a book ID
    public void editBookTitle(LibraryApp app, String title) {
        int editIndex = -1;
        for (int i = 0; i < fullCollection.size(); i++) {
            if(fullCollection.get(i).getBookID().equals(app.getBookID()))
            {
                editIndex = i;
            }
        }
        if(editIndex!=-1)
        {
            fullCollection.get(editIndex).setTitle(title);
        }

    }


    //edits a books author given an ID
    @Override
    public void editBookAuthor(LibraryApp app, List<String> author) {
        int editIndex = -1;
        for (int i = 0; i < fullCollection.size(); i++) {
            if(fullCollection.get(i).getBookID().equals(app.getBookID()))
            {
                editIndex = i;
            }
        }
        if(editIndex!=-1)
        {
            fullCollection.get(editIndex).setAuthors(author);
        }
    }

    //edits a book publish year based on a given ID
    @Override
    public void editBookYear(LibraryApp app, Integer year) {
        int editIndex = -1;
        for (int i = 0; i < fullCollection.size(); i++) {
            if(fullCollection.get(i).getBookID().equals(app.getBookID()))
            {
                editIndex = i;
            }
        }
        if(editIndex!=-1)
        {
            fullCollection.get(editIndex).setYear(year);
        }

    }


    //remove a book at a given index
    @Override
    public void deleteBook(Integer bookID) throws InvalidBookIDException {
        int removeIndex = -1;
        for(int i =0; i< fullCollection.size();i++)
        {
            if(fullCollection.get(i).getBookID().equals(bookID))
            {
                removeIndex = i;
                break;
            }
        }
        if(removeIndex!=-1)
        {
            fullCollection.remove(removeIndex);
        }
        else
        {
            throw new InvalidBookIDException("Cannot find book with ID "+ bookID +" to delete!");
        }

    }

    public void updateBook(LibraryApp app)
    {
        for( int i = 0; i < fullCollection.size(); i++){
            if( fullCollection.get(i).getBookID().equals(app.getBookID())){
                //we found the game to update
                fullCollection.set(i, new LibraryApp(app) );
            }
        }
    }
}
