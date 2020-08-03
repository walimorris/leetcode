package com.morris.augustchallenge;

/**
 * Design HashSet
 *
 * Design a HashSet without using any built-in hash table libraries.
 * To be specific, your design should include these functions:
 * A. add(value) : insert a value into the HashSet.
 * B. contains(value) : Return whether the value exists in the hashSet or not.
 * C. remove(value) : Remove a value in the HashSet. If teh value does not exist
 * in the HashSet, do nothing.
 *
 * @author Wali Morris
 * @since 08/02/2020
 * August Leetcode Challenge
 */

/**
 * The base structure for MyHashSet Object is an array. The size of the array must be recorded and closely 
 * monitored to keep track of the elements within the set and to give the set a dynamic feeling of growing
 * as users need to add elements. 
 */
public class MyHashSet {
    int[] set;
    int size;

    /**
     * MyHashSet begins as an array, set to accept a maximum of ten elements. The variable : size,  monitors the 
     * number of elements within the set. Ofcourse, once MyHashSet is instantiated, we begin with zero elements. 
     */
    public MyHashSet() {
        this.set = new int[10];
        this.size = 0;
    }

    /**
     * To add an element the user must provide the key to be added. Arrays are set on initiation so before adding
     * any element to the set, we ensure there is space enough for this element. If there is no space, the array is 
     * expanded by ten more available spaces. The set is then examined to ensure the key is not already within the
     * set; if the key is present, adding to the set is ignored. If the key is not present, element is added. 
     * @param key : element to add to set
     */
    public void add(int key) {
        if ( this.size == this.set.length ) {
            increaseSet();
        }
        if (!this.contains(key)) {
            this.set[size] = key;
            this.size++;
        }
    }

    /**
     * A private method used to dynamically increase the size of the base array used under the set. 
     * Increases the set by ten available spaces. 
     */
    private void increaseSet() {
        int[] temp = new int[this.size + 10];
        for ( int i = 0; i < this.size; i++ ) {
            temp[i] = this.set[i];
        }
        this.set = temp;
    }

    /**
     * Removes the key provided if it exists within the set. If the key exists, this method iterates to 
     * the index of the key and begins to move every key to the right of this index over to the left, 
     * removing the original key and decreasing the size of the set by one. 
     * @param key : the element to remove
     */
    public void remove(int key) {
        int index;
        for (int i = 0; i < this.size; i++) {
            if (this.set[i] == key) {
                index = i;
                while (index < this.size-1) {
                    this.set[index] = this.set[index + 1];
                    index++;
                }
                this.size--;
            }
        }
    }

    /**
     * Examines the set for the key provided
     * @param key : the element to search for within the set
     * @return : if the element exists return true, else false
     */
    public boolean contains(int key) {
        for (int i = 0; i < this.size; i++) {
            if ( this.set[i] == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if ( this.size == 0 ) {
            return "[]";
        }
        StringBuilder setStr = new StringBuilder();
        setStr.append("[");
        for ( int i = 0; i < this.size; i++ ) {
            setStr.append(this.set[i]);
            if (i == this.size - 1) {
                setStr.append("]");
            } else {
                setStr.append(", ");
            }
        }
        return setStr.toString();
    }

    /**
     * size of the element comes from the actual number of elements in the set.
     * @return : size of the set
     */
    public int getSize() {
        return this.size;
    }
}
