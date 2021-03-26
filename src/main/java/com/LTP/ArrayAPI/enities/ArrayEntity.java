package com.LTP.ArrayAPI.enities;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * ArrayEntity
 *
 * ArrayEntity class contains data stored as array of integers
 *
 * @version 1.0.0 23 March 2021
 * @author Daniil Selin
 */

public class ArrayEntity {

    private static final Logger LOGGER = LogManager.getLogger(ArrayEntity.class);

    /** Data container */
    private int array[];

    /**
     * Create an ArrayEntity with preassigned size
     * @param size - array
     * @see ArrayEntity#ArrayEntity(int)
     */
    public ArrayEntity(int size){
        this.array = new int[size];
        LOGGER.log(Level.INFO, "Array initialized successfully");
    }

    /**
     * Create an ArrayEntity with preassigned array
     * @param array - array to be stored
     * @see ArrayEntity#ArrayEntity(int[])
     */
    public ArrayEntity(int array[]){
        this.array = Arrays.copyOf(array, array.length);
        LOGGER.log(Level.INFO, "Array initialized successfully");
    }

    /**
     * Data setter {@link ArrayEntity#array}
     * @param array - new array to be stored
     */
    public void setArray(int array[]){
        this.array = Arrays.copyOf(array, array.length);
    }

    /**
     * Data getter {@link ArrayEntity#array}
     * @return Returns stored data
     */
    public int[] getArray(){
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public String toString(){
        return String.format("{ %s }", Arrays.stream(this.array).mapToObj(a -> Integer.toString(a)).collect(Collectors.joining(", ")));
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o.getClass() != this.getClass()) return false;
        ArrayEntity other = (ArrayEntity)o;
        if(!other.getArray().equals(this.array)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 17 * 31 + this.array.hashCode();
    }
}
