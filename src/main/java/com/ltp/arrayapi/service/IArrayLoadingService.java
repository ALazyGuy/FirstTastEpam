package com.ltp.arrayapi.service;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;

public interface IArrayLoadingService {
    ArrayEntity loadArray(String filename) throws ArrayException;
}
