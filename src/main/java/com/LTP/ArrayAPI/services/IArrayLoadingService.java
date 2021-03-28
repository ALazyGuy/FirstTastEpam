package com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.exceptions.ArrayException;

public interface IArrayLoadingService {
    ArrayEntity loadArray(String filename) throws ArrayException;
}
