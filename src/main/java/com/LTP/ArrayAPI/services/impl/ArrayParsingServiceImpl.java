package com.LTP.ArrayAPI.services.impl;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.services.IArrayParsingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * ArrayParsingService
 *
 * ArrayParsingService allows to parse String to {@link ArrayEntity}
 *
 * @version 1.0.0 27 March 2021
 * @author Daniil Selin
 */
public class ArrayParsingServiceImpl implements IArrayParsingService {

    private static final Logger LOGGER = LogManager.getLogger(ArrayParsingServiceImpl.class);
    private static ArrayParsingServiceImpl instance;

    /** Private constructor for singleton pattern */
    private ArrayParsingServiceImpl(){}

    /**
     * getInstance method allows to get class instance in singleton pattern
     * @return static instance of current class
     */
    public static ArrayParsingServiceImpl getInstance(){
        if(instance == null){
            instance = new ArrayParsingServiceImpl();
        }

        return instance;
    }

    /**
     * parse method allows you to parse input String to {@link ArrayEntity}
     * @param line - input String
     * @return ArrayEntity
     */
    @Override
    public ArrayEntity parse(String line) {
        String changed = Pattern.compile("(\\s+\\-\\s+|,\\s+)").matcher(line).replaceAll(" ");
        String[] numbers = changed.split(" ", 0);
        int[] array = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
        return new ArrayEntity(array);
    }
}
