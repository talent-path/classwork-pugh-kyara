package com.tp.gamemanagementsystem.exceptions;

public class NullReviewIDException extends Exception {

    public NullReviewIDException(String msg)
    {

        super(msg);
    }

    public NullReviewIDException(String msg, Throwable innerException)
    {

        super(msg, innerException);
    }
}
