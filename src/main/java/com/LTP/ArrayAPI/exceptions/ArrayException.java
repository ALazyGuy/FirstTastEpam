package com.LTP.ArrayAPI.exceptions;

/**
 * ArrayException
 *
 * ArrayException should be thrown if unable to proceed action with {@link com.LTP.ArrayAPI.enities.ArrayEntity}
 *
 * @version 1.0.0 26 March 2021
 * @author Daniil Selin
 */
public class ArrayException extends Exception{

    public ArrayException(){
        super();
    }

    public ArrayException(String message){
        super(message);
    }

    public ArrayException(Throwable cause){
        super(cause);
    }

    public ArrayException(String message, Throwable cause){
        super(message, cause);
    }

}
