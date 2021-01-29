package com.tp.libraryuserstory.exceptions;

public class NullAuthorException extends Exception{


    public NullAuthorException(String msg)
    {

        super(msg);
    }

    public NullAuthorException(String msg, Throwable innerException)
    {

        super(msg, innerException);
    }
}
