package com.ltp.arrayapi.service.impl;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;
import com.ltp.arrayapi.service.ISearchService;
import com.ltp.arrayapi.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

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
    public int findMaxValue(ArrayEntity arrayEntity) throws ArrayException {
        ArrayValidator.validateArray(arrayEntity);
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
    public int findMinValue(ArrayEntity arrayEntity) throws ArrayException{
        ArrayValidator.validateArray(arrayEntity);
        int arr[] = arrayEntity.getArray();
        int min = arr[0];
        for(int d = 1; d < arr.length; d++){
            if(min > arr[d]) min = arr[d];
        }
        LOGGER.log(Level.INFO, String.format("Min value in array %s is %d", arrayEntity.toString(), min));
        return min;
    }

    /**
     * Find maximal value in input array {@link ArrayEntity}
     *
     * @see SearchServiceImpl#findMinValueStream(ArrayEntity)
     * @param arrayEntity input array
     * @return Return maximal value in array
     */
    @Override
    public int findMaxValueStream(ArrayEntity arrayEntity) throws ArrayException {
        ArrayValidator.validateArray(arrayEntity);
        int max = IntStream.of(arrayEntity.getArray()).max().getAsInt();
        LOGGER.log(Level.INFO, String.format("Max value in array %s is %d", arrayEntity.toString(), max));
        return max;
    }

    /**
     * Find minimal value in input array {@link ArrayEntity}
     *
     * @see SearchServiceImpl#findMaxValueStream(ArrayEntity)
     * @param arrayEntity input array
     * @return Return minimal value in array
     */
    @Override
    public int findMinValueStream(ArrayEntity arrayEntity) throws ArrayException {
        ArrayValidator.validateArray(arrayEntity);
        int min = IntStream.of(arrayEntity.getArray()).min().getAsInt();
        LOGGER.log(Level.INFO, String.format("Min value in array %s is %d", arrayEntity.toString(), min));
        return min;
    }
}
