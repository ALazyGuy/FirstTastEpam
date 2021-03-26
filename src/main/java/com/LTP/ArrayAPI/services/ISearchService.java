package com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;

public interface ISearchService {
    int findMaxValue(ArrayEntity arrayEntity);
    int findMinValue(ArrayEntity arrayEntity);
}
