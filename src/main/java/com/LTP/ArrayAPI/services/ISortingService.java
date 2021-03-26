package com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;

public interface ISortingService {
    void bubbleSort(ArrayEntity arrayEntity);
    void insertionSort(ArrayEntity arrayEntity);
    void selectionSort(ArrayEntity arrayEntity);
}
