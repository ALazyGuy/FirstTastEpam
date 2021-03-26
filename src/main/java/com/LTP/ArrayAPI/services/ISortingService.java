package com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.exceptions.ArrayException;

public interface ISortingService {
    void bubbleSort(ArrayEntity arrayEntity) throws ArrayException;
    void insertionSort(ArrayEntity arrayEntity) throws ArrayException;
    void selectionSort(ArrayEntity arrayEntity) throws ArrayException;
}
