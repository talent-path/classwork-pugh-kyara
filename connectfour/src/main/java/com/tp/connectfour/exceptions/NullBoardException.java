package com.tp.connectfour.exceptions;

public class NullBoardException extends Exception{
    public NullBoardException( String message ){
        super( message );
    }

    public NullBoardException( String message, Throwable innerException ){

        super( message, innerException);
    }
}
