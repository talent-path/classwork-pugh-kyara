package com.tp.libraryuserstory.daos;

import com.tp.libraryuserstory.exceptions.InvalidBookIDException;
import com.tp.libraryuserstory.exceptions.NullAuthorException;
import com.tp.libraryuserstory.exceptions.NullTitleException;
import com.tp.libraryuserstory.exceptions.NullYearException;
import com.tp.libraryuserstory.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryInMemDAO implements LibraryDAO {

    private List<Book> fullCollection = new ArrayList<>();

    public LibraryInMemDAO()
    {
////        test book to add
//       Book firstBook = new Book(100, "My Book", "Jane Doe");
//       fullCollection.add(firstBook);
    }

    //create a new book
    @Override
    public Book createBook(Book book) throws NullAuthorException, NullTitleException, NullYearException {
        if(book.getTitle() == null)
        {
            throw new NullTitleException("Cannot add a book with a null title!");
        }
        if(book.getAuthors() == null)
        {
            throw new NullAuthorException("Cannot add a book with a null author!");
        }
        if(book.getYear() ==  null)
        {
            throw new NullYearException("Cannot add a book with a null year");
        }
        int id = 0;
        for(Book toCheck : fullCollection )
        {
            if(toCheck.getBookID()>id)
            {
                id = toCheck.getBookID();
            }
        }
        id++;

        Book copyBook = new Book(book);
        copyBook.setBookID(id);
        fullCollection.add(copyBook);
        return new Book(copyBook);
      }


    //returns a specific book
    @Override
    public Book getBookByID(Integer bookID) throws InvalidBookIDException{

        if(bookID == null)
        {
            throw new InvalidBookIDException("Cannot retrieve a book with a null ID!");
        }
        Book collection = null;
        for(int i =0; i< fullCollection.size();i++)
        {
            if(fullCollection.get(i).getBookID().equals(bookID))
            {
                collection = new Book(fullCollection.get(i));
            }
        }
        if(collection == null)
        {
            throw new InvalidBookIDException("Cannot retrieve a book with ID "+bookID+"!");
        }
        return collection;
    }

    //returns full library collection
    @Override
    public List<Book> getCollection() {
        List<Book> copyCollection = new ArrayList<>();
        for(Book toCopy : fullCollection)
        {
            copyCollection.add(new Book(toCopy));
        }
        return copyCollection;
    }
    
    @Override
    public List<Book> getBookByAuthor(String author) throws NullAuthorException {
        if(author == null)
        {
            throw new NullAuthorException("Cannot retrieve a book with null author");
        }
        List<Book> toReturn = new ArrayList<>();
        for(Book toCheck : fullCollection)
        {
            if(toCheck.getAuthors().contains(author))
            {
                toReturn.add(new Book(toCheck));
            }
        }
        if(toReturn.isEmpty())
        {
            throw new NullAuthorException("No book with author "+author+" could be found!");
        }
        return toReturn;
    }

    @Override
    public List<Book> getBookByTitle(String title) throws NullTitleException {
        if(title == null)
        {
            throw new NullTitleException("Cannot retrieve a book with a null title!");
        }
        List<Book> toReturn = new ArrayList<>();
        for(Book toCheck : fullCollection)
        {
            if(toCheck.getTitle().equals(title))
            {
                toReturn.add(new Book(toCheck));
            }
        }
        if(toReturn.isEmpty())
        {
            throw new NullTitleException("Cannot find a book with title "+ title +"!");
        }
        return toReturn;
    }

    @Override
    public List<Book> getBookByYear(Integer year) throws NullYearException {
        if(year == null)
        {
            throw new NullYearException("Cannot retrieve a book with null year!");
        }
        List<Book> toReturn = new ArrayList<>();
        for(Book toCheck : fullCollection)
        {
            if(toCheck.getYear().equals(year))
            {
                toReturn.add(new Book(toCheck));
            }
        }
        if(toReturn.isEmpty())
        {
            throw new NullYearException("Cannot find a book with year "+ year +"!");
        }
        return toReturn;
    }

    @Override
    public void editBook(Integer bookID, String newTitle, List<String>newAuthors, Integer newYear) throws InvalidBookIDException, NullAuthorException, NullTitleException,NullYearException {
        if(bookID == null)
        {
            throw new InvalidBookIDException("Cannot edit a book with null ID!");
        }
        if(newTitle==null)
        {
            throw new NullTitleException("Cannot edit a book with a null title!");
        }
        if(newAuthors==null)
        {
            throw new NullAuthorException("Cannot edit a book with a null author(s)!");
        }
        if(newYear==null)
        {
            throw new NullYearException("Cannot edit a book with a null year!");
        }
        //create a new book and set values to new passed in values
        Book toEdit = null;
        //find the original book in the collection and replace it with teh new book
        for (int i = 0; i < fullCollection.size(); i++) {
            if(fullCollection.get(i).getBookID().equals(bookID))
            {
                toEdit = getBookByID(bookID);
                toEdit.setTitle(newTitle);
                toEdit.setAuthors(newAuthors);
                toEdit.setYear(newYear);
                fullCollection.set(i,toEdit);
                break;
            }
        }
        //if that ID is not found
        if(toEdit == null)
        {
            throw new InvalidBookIDException("Cannot find a book with ID "+bookID+"!");
        }

    }

    //remove a book at a given index
    @Override
    public void deleteBook(Integer bookID) throws InvalidBookIDException {
        if(bookID == null)
        {
            throw new InvalidBookIDException("Cannot delete a book with a null ID!");
        }
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


    //i believe current methods will only delete the first instance of the passes value;
    @Override
    public void deleteBookByAuthor(String author) throws NullAuthorException {
        if(author == null)
        {
            throw new NullAuthorException("Cannot delete a book with a null ID!");
        }
        int removeIndex = -1;
        for(int i =0; i< fullCollection.size();i++)
        {
            if(fullCollection.get(i).getAuthors().contains(author))
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
            throw new NullAuthorException("Cannot find book with author "+ author +" to delete!");
        }

    }

    @Override
    public void deleteBookByTitle(String title) throws NullTitleException {
        if(title == null)
        {
            throw new NullTitleException("Cannot delete a book with a null ID!");
        }
        int removeIndex = -1;
        for(int i =0; i< fullCollection.size();i++)
        {
            if(fullCollection.get(i).getTitle().equals(title))
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
            throw new NullTitleException("Cannot find book with title "+ title +" to delete!");
        }

    }


    @Override
    public void deleteBookByYear(Integer year) throws NullYearException {
        if(year == null)
        {
            throw new NullYearException("Cannot delete a book with a null ID!");
        }
        int removeIndex = -1;
        for(int i =0; i< fullCollection.size();i++)
        {
            if(fullCollection.get(i).getYear().equals(year))
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
            throw new NullYearException("Cannot find book with year "+ year +" to delete!");
        }

    }

}

