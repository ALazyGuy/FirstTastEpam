package com.ltp.arrayapi.service.impl;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;
import com.ltp.arrayapi.service.IReplaceService;
import com.ltp.arrayapi.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * ReplaceService
 *
 * ReplaceService class allows to replace some elements stored in {@link ArrayEntity}
 *
 * @version 1.0.0 23 March 2021
 * @author Daniil Selin
 */

public class ReplaceServiceImpl implements IReplaceService {

    private static final Logger LOGGER = LogManager.getLogger(ReplaceServiceImpl.class);
    private static ReplaceServiceImpl instance = null;

    /** Private constructor for singleton pattern */
    private ReplaceServiceImpl(){}

    /**
     * getInstance method allows to get class instance in singleton pattern
     * @return static instance of current class
     */
    public static ReplaceServiceImpl getInstance(){
        if(instance == null){
            instance = new ReplaceServiceImpl();
        }

        return instance;
    }

    /**
     * replaceByValue method allows to replace every element that suitable by condition
     *
     * @param entity - ArrayEntity whose elements would be replaced
     * @param condition - Condition to choose elements
     * @param newValue - A new value for every element suitable by condition
     */
    @Override
    public void replaceByValue(ArrayEntity entity, Predicate<Integer> condition, int newValue) throws ArrayException {
        if(ArrayValidator.validateArray(entity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        if(condition == null){
            throw new ArrayException("Condition cannot be null");
        }

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
    @Override
    public void replace(ArrayEntity entity, Predicate<Integer> condition, Function<Integer, Integer> function) throws ArrayException{
        if(ArrayValidator.validateArray(entity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        if(condition == null){
            throw new ArrayException("Condition cannot be null");
        }

        if(function == null){
            throw new ArrayException("Function cannot be null");
        }

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

    /**
     * replaceByValueStream method allows to replace every element that suitable by condition
     *
     * @param entity - ArrayEntity whose elements would be replaced
     * @param condition - Condition to choose elements
     * @param newValue - A new value for every element suitable by condition
     */
    @Override
    public void replaceByValueStream(ArrayEntity entity, Predicate<Integer> condition, int newValue) throws ArrayException {
        if(ArrayValidator.validateArray(entity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        if(condition == null){
            throw new ArrayException("Condition cannot be null");
        }

        String input = entity.toString();
        int[] newValues = IntStream.of(entity.getArray()).map(a -> condition.test(a) ? newValue : a).toArray();
        entity.setArray(newValues);
        LOGGER.log(Level.INFO, String.format("Array %s after replaceByValue is %s", input, entity.toString()));
    }

    /**
     * replaceByValueStream method allows to replace every element that suitable by condition
     *
     * @param entity - ArrayEntity whose elements would be replaced
     * @param condition - Condition to choose elements
     * @param function - Function to calculate a new value for every element suitable by condition
     */
    @Override
    public void replaceStream(ArrayEntity entity, Predicate<Integer> condition, Function<Integer, Integer> function) throws ArrayException {
        if(ArrayValidator.validateArray(entity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        if(condition == null){
            throw new ArrayException("Condition cannot be null");
        }

        if(function == null){
            throw new ArrayException("Function cannot be null");
        }

        String input = entity.toString();
        int[] newValues = IntStream.of(entity.getArray()).map(a -> condition.test(a) ? function.apply(a) : a).toArray();
        entity.setArray(newValues);
        LOGGER.log(Level.INFO, String.format("Array %s after replace is %s", input, entity.toString()));
    }
}
