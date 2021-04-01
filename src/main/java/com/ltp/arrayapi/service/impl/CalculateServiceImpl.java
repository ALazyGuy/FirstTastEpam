package com.ltp.arrayapi.service.impl;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;
import com.ltp.arrayapi.service.ICalculateService;
import com.ltp.arrayapi.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * CalculateService
 *
 * CalculateService class allows to do mathematical calculations with {@link ArrayEntity}
 *
 * @version 1.0.2 29 March 2021
 * @author Daniil Selin
 */

public class CalculateServiceImpl implements ICalculateService {

    private static final Logger LOGGER = LogManager.getLogger(CalculateServiceImpl.class);
    private static CalculateServiceImpl instance = null;

    /** Private constructor for singleton pattern */
    private CalculateServiceImpl(){}

    /**
     * getInstance method allows to get class instance in singleton pattern
     * @return static instance of current class
     */
    public static CalculateServiceImpl getInstance(){
        if(instance == null){
            instance = new CalculateServiceImpl();
        }
        return instance;
    }

    /**
     * averageStream method allows you to find average of an array
     * @param arrayEntity - input array
     * @return return average of an input array
     */
    @Override
    public double averageStream(ArrayEntity arrayEntity) throws ArrayException {
        if(!ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        double average = Arrays.stream(arrayEntity.getArray()).average().getAsDouble();
        LOGGER.log(Level.INFO, String.format("Average of an %s is %f", arrayEntity.toString(), average));
        return average;
    }

    /**
     * sumStream(ArrayEntity) method allows you to find sum of all elements in array
     * @param arrayEntity - input array
     * @return return sum of all elements in input array
     * @see CalculateServiceImpl#sumStream(ArrayEntity, int, int)
     */
    @Override
    public int sumStream(ArrayEntity arrayEntity) throws ArrayException{
        if(!ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        return sumStream(arrayEntity, 0, arrayEntity.getArray().length - 1);
    }

    /**
     * sumStream(ArrayEntity, int, int) method allows you to find sum of elements between start and stop indexes including them
     * @param arrayEntity - input array
     * @return return sum of elements between start and stop indexes including them
     * @see CalculateServiceImpl#sumStream(ArrayEntity)
     */
    @Override
    public int sumStream(ArrayEntity arrayEntity, int start, int stop) throws ArrayException{
        if(!ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        if(start < 0 || start >= stop || stop >= arrayEntity.getArray().length){
            throw new ArrayException("Invalid bounds in input array");
        }

        int result = Arrays.stream(arrayEntity.getArray()).skip(start).limit(stop - start + 1).sum();
        LOGGER.log(Level.INFO, String.format("Sum of %s from index %d to index %d is %d",
                                             arrayEntity.toString(),
                                             start,
                                             stop,
                                             result));
        return result;
    }

    /**
     * countPositivesStream method allows you to count all positive number in an array
     * @param arrayEntity - input array
     * @return return count of all positive numbers including zero
     * @see CalculateServiceImpl#countNegatives(ArrayEntity)
     */
    @Override
    public int countPositivesStream(ArrayEntity arrayEntity) throws ArrayException{
        if(!ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        int result = (int)Arrays.stream(arrayEntity.getArray()).filter(a -> a >= 0).count();
        LOGGER.log(Level.INFO, String.format("Count of positive numbers in %s is %d", arrayEntity.toString(), result));
        return result;
    }

    /**
     * countNegativesStream method allows you to count all negative number in an array
     * @param arrayEntity - input array
     * @return return count of all negative numbers except zero
     * @see CalculateServiceImpl#countPositives(ArrayEntity)
     */
    @Override
    public int countNegativesStream(ArrayEntity arrayEntity) throws ArrayException{
        if(!ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        int result = arrayEntity.getArray().length - countPositivesStream(arrayEntity);
        LOGGER.log(Level.INFO, String.format("Count of negative numbers in %s is %d", arrayEntity.toString(), result));
        return result;
    }

    /**
     * average method allows you to find average of an array
     * @param arrayEntity - input array
     * @return return average of an input array
     */
    @Override
    public double average(ArrayEntity arrayEntity) throws ArrayException {
        if(!ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        int[] array = arrayEntity.getArray();
        double average = sum(arrayEntity);
        average /= array.length;
        LOGGER.log(Level.INFO, String.format("Average of an %s is %f", arrayEntity.toString(), average));
        return average;
    }

    /**
     * sum(ArrayEntity) method allows you to find sum of all elements in array
     * @param arrayEntity - input array
     * @return return sum of all elements in input array
     * @see CalculateServiceImpl#sum(ArrayEntity, int, int)
     */
    @Override
    public int sum(ArrayEntity arrayEntity) throws ArrayException {
        if(ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        return sumStream(arrayEntity, 0, arrayEntity.getArray().length - 1);
    }

    /**
     * sum(ArrayEntity, int, int) method allows you to find sum of elements between start and stop indexes including them
     * @param arrayEntity - input array
     * @return return sum of elements between start and stop indexes including them
     * @see CalculateServiceImpl#sum(ArrayEntity)
     */
    @Override
    public int sum(ArrayEntity arrayEntity, int start, int stop) throws ArrayException {
        if(!ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        if(start < 0 || start >= stop || stop >= arrayEntity.getArray().length){
            throw new ArrayException("Invalid bounds in input array");
        }

        int[] array = arrayEntity.getArray();
        int result = 0;

        for( ; start <= stop; start++){
            result += array[start];
        }

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
    public int countPositives(ArrayEntity arrayEntity) throws ArrayException {
        if(!ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        int result = 0;
        int[] array = arrayEntity.getArray();

        for(int current : array){
            if(current >= 0) result++;
        }

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
    public int countNegatives(ArrayEntity arrayEntity) throws ArrayException {
        if(!ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        int result = arrayEntity.getArray().length - countPositives(arrayEntity);
        LOGGER.log(Level.INFO, String.format("Count of negative numbers in %s is %d", arrayEntity.toString(), result));
        return result;
    }
}
