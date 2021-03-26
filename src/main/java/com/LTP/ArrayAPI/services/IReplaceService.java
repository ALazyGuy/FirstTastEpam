package com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;

import java.util.function.Function;
import java.util.function.Predicate;

public interface IReplaceService {
    void replaceByValue(ArrayEntity entity, Predicate<Integer> condition, int newValue);
    void replace(ArrayEntity entity, Predicate<Integer> condition, Function<Integer, Integer> function)
}
