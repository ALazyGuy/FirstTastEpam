package com.ltp.arrayapi.service.impl;

import com.ltp.arrayapi.exception.ArrayException;
import com.ltp.arrayapi.service.IFileReadingService;
import com.ltp.arrayapi.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * FileReadingServiceImpl
 *
 * FileReadingServiceImpl allows to read data from file
 *
 * @version 1.0.0 27 March 2021
 * @author Daniil Selin
 */
public class FileReadingServiceImpl implements IFileReadingService {

    private static final Logger LOGGER = LogManager.getLogger(FileReadingServiceImpl.class);
    private static FileReadingServiceImpl instance = null;

    /** Private constructor for singleton pattern */
    private FileReadingServiceImpl(){}

    /**
     * getInstance method allows to get class instance in singleton pattern
     * @return static instance of current class
     */
    public static FileReadingServiceImpl getInstance(){
        if(instance == null){
            instance = new FileReadingServiceImpl();
        }

        return instance;
    }

    /**
     * readLine methods allows to load first valid line from file "filename"
     * @param filename - input file path
     * @return first valid line
     * @throws ArrayException will be thrown if no file found or no valid line found
     */
    @Override
    public String readLine(String filename) throws ArrayException {
        if(!ArrayValidator.validateFilePath(filename)){
            throw new ArrayException("Input file not found");
        }

        String rightLine = null;

        try{
            List<String> lines = Files.readAllLines(Paths.get(filename));

            for(String t : lines){
                if(ArrayValidator.validateArrayString(t)){
                    rightLine = t;
                    break;
                }
            }

            if(rightLine == null){
                throw new ArrayException(String.format("No valid line found in file %s", filename));
            }
        }catch(IOException e){
            LOGGER.log(Level.ERROR, String.format("Error while reading file %s", filename));
            throw new ArrayException(String.format("Error while reading file %s", filename));
        }

        return rightLine;
    }
}
