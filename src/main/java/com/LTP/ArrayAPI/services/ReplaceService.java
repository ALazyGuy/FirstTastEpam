package com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * ReplaceService
 *
 * ReplaceService class allows to replace some elements stored in {@link ArrayEntity}
 *
 * @version 1.0.0 23 March 2021
 * @author Daniil Selin
 */

public class ReplaceService {

    private static final Logger LOGGER = LogManager.getLogger(ReplaceService.class);

    /** Private constructor for singleton pattern */
    private ReplaceService(){}

    /**
     * replaceByValue method allows to replace every element that suitable by condition
     *
     * @param entity - ArrayEntity whose elements would be replaced
     * @param condition - Condition to choose elements
     * @param newValue - A new value for every element suitable by condition
     */
    public static void replaceByValue(ArrayEntity entity, Predicate<Integer> condition, int newValue){
        if(entity == null) throw new IllegalArgumentException("Input array cannot be null");
        if(condition == null) throw new IllegalArgumentException("Condition cannot be null");
        String input = entity.toString();
        int[] arr = entity.getArray();
        for(int d = 0; d < arr.length; d++){
            if(condition.test(arr[d])){
                arr[d] = newValue;
            }
        }
        entity.setArray(arr);
        LOGGER.log(Level.INFO, String.format("Array %s after replaceByValue is %s", input, entity.toString()));
    }

    /**
     * replaceByValue method allows to replace every element that suitable by condition
     *
     * @param entity - ArrayEntity whose elements would be replaced
     * @param condition - Condition to choose elements
     * @param function - Function to calculate a new value for every element suitable by condition
     */
    public static void replace(ArrayEntity entity, Predicate<Integer> condition, Function<Integer, Integer> function){
        if(entity == null) throw new IllegalArgumentException("Input array cannot be null");
        if(condition == null) throw new IllegalArgumentException("Condition cannot be null");
        if(function == null) throw new IllegalArgumentException("Function cannot be null");
        String input = entity.toString();
        int[] arr = entity.getArray();
        for(int d = 0; d < arr.length; d++){
            if(condition.test(arr[d])){
                arr[d] = function.apply(arr[d]);
            }
        }
        entity.setArray(arr);
        LOGGER.log(Level.INFO, String.format("Array %s after replace is %s", input, entity.toString()));
    }


}
