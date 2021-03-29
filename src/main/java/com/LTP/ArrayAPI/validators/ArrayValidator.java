package com.LTP.ArrayAPI.validators;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.exceptions.ArrayException;

import java.util.regex.Pattern;

/**
 * ArrayValidator
 *
 * ArrayValidator allows to validate if string or {@link ArrayEntity} is valid
 *
 * @version 1.0.2 29 March 2021
 * @author Daniil Selin
 */
public class ArrayValidator {

    /** Private constructor for singleton */
    private ArrayValidator(){}

    /**
     * validateArray allows you to validate array(not empty, not null)
     * @param arrayEntity - input array
     * @throws ArrayException will be thrown if array is invalid
     */
    public static void validateArray(ArrayEntity arrayEntity) throws ArrayException{
        if(arrayEntity == null) throw new ArrayException("Input array cannot be null");
        if(arrayEntity.getArray().length == 0) throw new ArrayException("Input array cannot be empty");
    }

    /**
     * validateArrayString allows you to check if there is possibility to parse input string to {@link ArrayEntity}
     * @param line - input string to validate
     * @return Is string valid
     */
    public static boolean validateArrayString(String line){
        if(line == null || line.length() == 0) return false;
        String validPattern = "(\\-?\\d+(\\s+|\\s+\\-\\s+|,\\s+|$))*";
        return Pattern.matches(validPattern, line);
    }

}
