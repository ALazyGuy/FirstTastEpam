package com.LTP.ArrayAPI.validators;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.exceptions.ArrayException;

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

}
