package com.tp.gamemanagementsystem.exceptions;

public class InvalidGameIDException extends Exception{

    public InvalidGameIDException(String msg)
    {

        super(msg);
    }

    public InvalidGameIDException(String msg, Throwable innerException)
    {

        super(msg, innerException);
    }

}
