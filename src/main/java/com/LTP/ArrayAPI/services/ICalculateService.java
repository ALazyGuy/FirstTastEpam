package com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;

public interface ICalculateService {
    double average(ArrayEntity arrayEntity);
    int sum(ArrayEntity arrayEntity);
    int sum(ArrayEntity arrayEntity, int start, int stop);
    int countPositives(ArrayEntity arrayEntity);
    int countNegatives(ArrayEntity arrayEntity);
}
