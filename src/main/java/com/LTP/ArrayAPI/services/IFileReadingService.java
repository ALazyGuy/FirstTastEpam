package com.LTP.ArrayAPI.services;

import com.LTP.ArrayAPI.exceptions.ArrayException;

public interface IFileReadingService {
    public String readLine(String filename) throws ArrayException;
}
