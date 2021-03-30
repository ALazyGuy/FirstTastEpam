package com.ltp.arrayapi.service;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;

public interface ICalculateService {
    double average(ArrayEntity arrayEntity) throws ArrayException;
    double averageStream(ArrayEntity arrayEntity) throws ArrayException;
    int sum(ArrayEntity arrayEntity) throws ArrayException;
    int sumStream(ArrayEntity arrayEntity) throws ArrayException;
    int sum(ArrayEntity arrayEntity, int start, int stop) throws ArrayException;
    int sumStream(ArrayEntity arrayEntity, int start, int stop) throws ArrayException;
    int countPositives(ArrayEntity arrayEntity) throws ArrayException;
    int countPositivesStream(ArrayEntity arrayEntity) throws ArrayException;
    int countNegatives(ArrayEntity arrayEntity) throws ArrayException;
    int countNegativesStream(ArrayEntity arrayEntity) throws ArrayException;
}
