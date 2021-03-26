package com.LTP.ArrayAPI.services.impl;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.services.ISearchService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * SearchService
 *
 * SearchService allows to find minimal and maximal values in ArrayEntity
 *
 * @version 1.0.0 23 March 2021
 * @author Daniil Selin
 */

public class SearchServiceImpl implements ISearchService {

    private static final Logger LOGGER = LogManager.getLogger(SearchServiceImpl.class);
    private static SearchServiceImpl instance = null;

    /** Private constructor for singleton pattern */
    private SearchServiceImpl(){}

    /**
     * getInstance method allows to get class instance in singleton pattern
     * @return static instance of current class
     */
    public static SearchServiceImpl getInstance(){
        if(instance == null){
            instance = new SearchServiceImpl();
        }

        return instance;
    }

    /**
     * Find maximal value in input array {@link ArrayEntity}
     *
     * @see SearchServiceImpl#findMinValue(ArrayEntity)
     * @param arrayEntity input array
     * @return Return maximal value in array
     */
    @Override
    public int findMaxValue(ArrayEntity arrayEntity){
        if(arrayEntity == null || arrayEntity.getArray().length == 0) throw new IllegalArgumentException("Input array can't be empty");
        int arr[] = arrayEntity.getArray();
        int max = arr[0];
        for(int d = 1; d < arr.length; d++){
            if(max < arr[d]) max = arr[d];
        }
        LOGGER.log(Level.INFO, String.format("Max value in array %s is %d", arrayEntity.toString(), max));
        return max;
    }

    /**
     * Find minimal value in input array {@link ArrayEntity}
     *
     * @see SearchServiceImpl#findMaxValue(ArrayEntity)
     * @param arrayEntity input array
     * @return Return minimal value in array
     */
    @Override
    public int findMinValue(ArrayEntity arrayEntity){
        if(arrayEntity == null || arrayEntity.getArray().length == 0) throw new IllegalArgumentException("Input array can't be empty");
        int arr[] = arrayEntity.getArray();
        int min = arr[0];
        for(int d = 1; d < arr.length; d++){
            if(min > arr[d]) min = arr[d];
        }
        LOGGER.log(Level.INFO, String.format("Min value in array %s is %d", arrayEntity.toString(), min));
        return min;
    }

}
