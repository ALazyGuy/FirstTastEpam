package com.ltp.arrayapi.service.impl;

import com.ltp.arrayapi.entity.ArrayEntity;
import com.ltp.arrayapi.exception.ArrayException;
import com.ltp.arrayapi.service.IArrayLoadingService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ArrayLoadingServiceImpl
 *
 * ArrayLoadingServiceImpl allows to get an {@link ArrayEntity} from file
 *
 * @version 1.0.2 29 March 2021
 * @author Daniil Selin
 */
public class ArrayLoadingServiceImpl implements IArrayLoadingService {

    private static final Logger LOGGER = LogManager.getLogger(ArrayLoadingServiceImpl.class);
    private static ArrayLoadingServiceImpl instance = null;

    /** Private constructor for singleton pattern */
    private ArrayLoadingServiceImpl(){}

    /**
     * getInstance method allows to get class instance in singleton pattern
     * @return static instance of current class
     */
    public static ArrayLoadingServiceImpl getInstance(){
        if(instance == null){
            instance = new ArrayLoadingServiceImpl();
        }

        return instance;
    }

    /**
     * loadArray method allows you to load {@link ArrayEntity} from input file
     * @param filename - input file path
     * @return loaded ArrayEntity from file
     * @throws ArrayException will be thrown if unable to load data from file
     */
    @Override
    public ArrayEntity loadArray(String filename) throws ArrayException {
        String line = FileReadingServiceImpl.getInstance().readLine(filename);
        ArrayEntity result = ArrayParsingServiceImpl.getInstance().parse(line);
        LOGGER.log(Level.INFO, String.format("Array %s successfully loaded from %s", result.toString(), filename));
        return result;
    }
}
