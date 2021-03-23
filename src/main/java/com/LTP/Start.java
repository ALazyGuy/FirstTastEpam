package com.LTP;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import com.LTP.ArrayAPI.services.SearchService;

public class Start {

    public static void main(String[] args) {
        ArrayEntity entity = new ArrayEntity(new int[]{1, 7, -4, 7, 2});
        SearchService.findMaxValue(entity);
        SearchService.findMinValue(entity);
    }

}