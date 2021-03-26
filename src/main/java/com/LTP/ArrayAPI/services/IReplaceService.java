package com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.exceptions.ArrayException;

import java.util.function.Function;
import java.util.function.Predicate;

public interface IReplaceService {
    void replaceByValue(ArrayEntity entity, Predicate<Integer> condition, int newValue) throws ArrayException;
    void replace(ArrayEntity entity, Predicate<Integer> condition, Function<Integer, Integer> function)  throws ArrayException;
}
