package com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.exceptions.ArrayException;

public interface ICalculateService {
    double average(ArrayEntity arrayEntity) throws ArrayException;
    int sum(ArrayEntity arrayEntity) throws ArrayException;
    int sum(ArrayEntity arrayEntity, int start, int stop) throws ArrayException;
    int countPositives(ArrayEntity arrayEntity) throws ArrayException;
    int countNegatives(ArrayEntity arrayEntity) throws ArrayException;
}
