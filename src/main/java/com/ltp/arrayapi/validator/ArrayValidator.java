package com.ltp.arrayapi.validator;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;

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
    public static boolean validateArray(ArrayEntity arrayEntity) throws ArrayException{
        return arrayEntity != null && arrayEntity.getArray().length != 0;
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
