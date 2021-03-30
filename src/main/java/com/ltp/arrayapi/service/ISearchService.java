package com.ltp.arrayapi.service;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;

public interface ISearchService {
    int findMaxValue(ArrayEntity arrayEntity) throws ArrayException;
    int findMinValue(ArrayEntity arrayEntity) throws ArrayException;
    int findMaxValueStream(ArrayEntity arrayEntity) throws ArrayException;
    int findMinValueStream(ArrayEntity arrayEntity) throws ArrayException;
}
