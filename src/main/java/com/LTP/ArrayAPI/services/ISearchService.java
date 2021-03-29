package com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.exceptions.ArrayException;

public interface ISearchService {
    int findMaxValue(ArrayEntity arrayEntity) throws ArrayException;
    int findMinValue(ArrayEntity arrayEntity) throws ArrayException;
    int findMaxValueStream(ArrayEntity arrayEntity) throws ArrayException;
    int findMinValueStream(ArrayEntity arrayEntity) throws ArrayException;
}
