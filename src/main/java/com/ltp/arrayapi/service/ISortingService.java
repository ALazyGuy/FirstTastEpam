package com.ltp.arrayapi.service;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;

public interface ISortingService {
    void bubbleSort(ArrayEntity arrayEntity) throws ArrayException;
    void insertionSort(ArrayEntity arrayEntity) throws ArrayException;
    void selectionSort(ArrayEntity arrayEntity) throws ArrayException;
}
