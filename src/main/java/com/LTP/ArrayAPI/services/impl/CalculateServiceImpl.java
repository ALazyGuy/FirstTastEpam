package com.LTP.ArrayAPI.services.impl;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.services.ICalculateService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * CalculateService
 *
 * CalculateService class allows to do mathematical calculations with {@link ArrayEntity}
 */

public class CalculateServiceImpl implements ICalculateService {

    private static final Logger LOGGER = LogManager.getLogger(CalculateServiceImpl.class);

    /** Private constructor for singleton pattern */
    private CalculateServiceImpl(){}

    /**
     * average method allows you to find average of an array
     * @param arrayEntity - input array
     * @return return average of an input array
     */
    @Override
    public double average(ArrayEntity arrayEntity){
        if(arrayEntity == null) throw new IllegalArgumentException("Input array cannot be null");
        if(arrayEntity.getArray().length == 0) return .0;
        double result = Arrays.stream(arrayEntity.getArray()).sum();
        LOGGER.log(Level.INFO, String.format("Average of an %s is %f", arrayEntity.toString(), result / arrayEntity.getArray().length));
        return result / arrayEntity.getArray().length;
    }

    /**
     * sum(ArrayEntity) method allows you to find sum of all elements in array
     * @param arrayEntity - input array
     * @return return sum of all elements in input array
     * @see CalculateServiceImpl#sum(ArrayEntity, int, int)
     */
    @Override
    public int sum(ArrayEntity arrayEntity){
        if(arrayEntity == null) throw new IllegalArgumentException("Input array cannot be null");
        return sum(arrayEntity, 0, arrayEntity.getArray().length - 1);
    }

    /**
     * sum(ArrayEntity, int, int) method allows you to find sum of elements between start and stop indexes including them
     * @param arrayEntity - input array
     * @return return sum of elements between start and stop indexes including them
     * @see CalculateServiceImpl#sum(ArrayEntity)
     */
    @Override
    public int sum(ArrayEntity arrayEntity, int start, int stop){
        if(arrayEntity == null) throw new IllegalArgumentException("Input array cannot be null");
        if(start < 0 || start >= stop || stop >= arrayEntity.getArray().length) throw new IndexOutOfBoundsException("Invalid bounds in input array");
        int result = Arrays.stream(arrayEntity.getArray()).skip(start).limit(stop - start + 1).sum();
        LOGGER.log(Level.INFO, String.format("Sum of %s from index %d to index %d is %d",
                                             arrayEntity.toString(),
                                             start,
                                             stop,
                                             result));
        return result;
    }

    /**
     * countPositives method allows you to count all positive number in an array
     * @param arrayEntity - input array
     * @return return count of all positive numbers including zero
     * @see CalculateServiceImpl#countNegatives(ArrayEntity)
     */
    @Override
    public int countPositives(ArrayEntity arrayEntity){
        if(arrayEntity == null) throw new IllegalArgumentException("Input array cannot be null");
        if(arrayEntity.getArray().length == 0) return 0;
        int result = (int)Arrays.stream(arrayEntity.getArray()).filter(a -> a >= 0).count();
        LOGGER.log(Level.INFO, String.format("Count of positive numbers in %s is %d", arrayEntity.toString(), result));
        return result;
    }

    /**
     * countNegatives method allows you to count all negative number in an array
     * @param arrayEntity - input array
     * @return return count of all negative numbers except zero
     * @see CalculateServiceImpl#countPositives(ArrayEntity)
     */
    @Override
    public int countNegatives(ArrayEntity arrayEntity){
        if(arrayEntity == null) throw new IllegalArgumentException("Input array cannot be null");
        int result = arrayEntity.getArray().length - countPositives(arrayEntity);
        LOGGER.log(Level.INFO, String.format("Count of negative numbers in %s is %d", arrayEntity.toString(), result));
        return result;
    }

}
