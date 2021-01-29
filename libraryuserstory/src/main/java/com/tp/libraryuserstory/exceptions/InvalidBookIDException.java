package com.tp.libraryuserstory.exceptions;

public class InvalidBookIDException extends Exception {

    public InvalidBookIDException(String msg)
    {
        super(msg);
    }

    public InvalidBookIDException(String msg, Throwable innerException)
    {
        super(msg, innerException);
    }
}
