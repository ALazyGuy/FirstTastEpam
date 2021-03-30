package com.ltp.arrayapi.service.impl;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;
import com.ltp.arrayapi.service.ISortingService;
import com.ltp.arrayapi.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * SortingServiceImpl
 * SortingServiceImpl class allows to sort {@link ArrayEntity}
 *
 * @version 1.0.0 26 March 2021
 * @author Daniil Selin
 */
public class SortingServiceImpl implements ISortingService {

    private static final Logger LOGGER = LogManager.getLogger(SortingServiceImpl.class);
    private static SortingServiceImpl instance = null;

    /** Private constructor for singleton pattern */
    private  SortingServiceImpl(){}

    /**
     * getInstance method allows to get class instance in singleton pattern
     * @return static instance of current class
     */
    public static SortingServiceImpl getInstance(){
        if(instance == null){
            instance = new SortingServiceImpl();
        }

        return instance;
    }

    /**
     * bubbleSort method allows you to sort {@link ArrayEntity} by bubble sorting algorithm
     * @param arrayEntity - input array
     */
    @Override
    public void bubbleSort(ArrayEntity arrayEntity) throws ArrayException {
        if(ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        int[] array = arrayEntity.getArray();

        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }

        LOGGER.log(Level.INFO, String.format("Array %s sorted by bubble sort", arrayEntity.toString()));
        arrayEntity.setArray(array);
    }

    /**
     * insertionSort method allows you to sort {@link ArrayEntity} by insertion sorting algorithm
     * @param arrayEntity - input array
     */
    @Override
    public void insertionSort(ArrayEntity arrayEntity) throws ArrayException{
        if(ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        int[] array = arrayEntity.getArray();

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }

        LOGGER.log(Level.INFO, String.format("Array %s sorted by insertion sort", arrayEntity.toString()));
        arrayEntity.setArray(array);
    }

    /**
     * selectionSort method allows you to sort {@link ArrayEntity} by selection sorting algorithm
     * @param arrayEntity - input array
     */
    @Override
    public void selectionSort(ArrayEntity arrayEntity) throws ArrayException {
        if(ArrayValidator.validateArray(arrayEntity)){
            throw new ArrayException("Invalid input array [empty or null]");
        }

        int[] array = arrayEntity.getArray();

        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }

        LOGGER.log(Level.INFO, String.format("Array %s sorted by selection sort", arrayEntity.toString()));
        arrayEntity.setArray(array);
    }
}
