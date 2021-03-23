package com.LTP.ArrayAPI.enities;

/**
 * ArrayEntity
 *
 * ArrayEntity class contains data stored as array of integers
 *
 * @version 1.0.0 23 March 2021
 * @author Daniil Selin
 */

public class ArrayEntity {

    /** Data container */
    private int array[];

    /**
     * Create an ArrayEntity with preassigned size
     * @param size - array
     * @see ArrayEntity#ArrayEntity(int)
     */
    public ArrayEntity(int size){
        this.array = new int[size];
    }

    /**
     * Create an ArrayEntity with preassigned array
     * @param array - array to be stored
     * @see ArrayEntity#ArrayEntity(int[])
     */
    public ArrayEntity(int array[]){
        this.array = array;
    }

    /**
     * Data setter {@link ArrayEntity#array}
     * @param array - new array to be stored
     */
    public void setArray(int array[]){
        this.array = array;
    }

    /**
     * Data getter {@link ArrayEntity#array}
     * @return Returns stored data
     */
    public int[] getArray(){
        return this.array;
    }

}
