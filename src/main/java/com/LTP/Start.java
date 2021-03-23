package com.LTP;

import com.LTP.ArrayAPI.enities.ArrayEntity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Start {

    private static final Logger logger = LogManager.getLogger(Start.class);

    public static void main(String[] args) {
        ArrayEntity entity = new ArrayEntity(new int[]{1, 7, -4, 7, 2});
        logger.log(Level.DEBUG, entity.toString());
    }

}