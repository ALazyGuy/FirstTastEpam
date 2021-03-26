package com.LTP.ArrayAPI.validators;

import com.LTP.ArrayAPI.enities.ArrayEntity;

public class ArrayValidator {

    /** Private constructor for singleton */
    private ArrayValidator(){}

    /**
     * validateArray allows you to validate array(not empty, not null)
     * @param arrayEntity - input array
     * @return is array valid
     */
    public static boolean validateArray(ArrayEntity arrayEntity){
        return (arrayEntity != null) && (arrayEntity.getArray().length > 0);
    }

}
