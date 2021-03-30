package com.ltp.arrayapi.service;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;

import java.util.function.Function;
import java.util.function.Predicate;

public interface IReplaceService {
    void replaceByValue(ArrayEntity entity, Predicate<Integer> condition, int newValue) throws ArrayException;
    void replace(ArrayEntity entity, Predicate<Integer> condition, Function<Integer, Integer> function)  throws ArrayException;
    void replaceByValueStream(ArrayEntity entity, Predicate<Integer> condition, int newValue) throws ArrayException;
    void replaceStream(ArrayEntity entity, Predicate<Integer> condition, Function<Integer, Integer> function)  throws ArrayException;
}
