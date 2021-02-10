package com.tp.gamemanagementsystem.exceptions;

public class NullGameIDException extends Exception {

    public NullGameIDException(String msg)
    {

        super(msg);
    }

    public NullGameIDException(String msg, Throwable innerException)
    {

        super(msg, innerException);
    }
}
