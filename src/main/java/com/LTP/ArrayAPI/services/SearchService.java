package com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;
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

public class SearchService {

    private static final Logger LOGGER = LogManager.getLogger(SearchService.class);

    /** Private constructor for singleton pattern */
    private SearchService(){}

    /**
     * Find maximal value in input array {@link ArrayEntity}
     *
     * @see SearchService#findMinValue(ArrayEntity)
     * @param arrayEntity input array
     * @return Return maximal value in array
     */
    public static int findMaxValue(ArrayEntity arrayEntity){
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
     * @see SearchService#findMaxValue(ArrayEntity)
     * @param arrayEntity input array
     * @return Return minimal value in array
     */
    public static int findMinValue(ArrayEntity arrayEntity){
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
