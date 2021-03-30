package com.ltp.arrayapi.service;

import com.ltp.arrayapi.exception.ArrayException;

public interface IFileReadingService {
    public String readLine(String filename) throws ArrayException;
}
