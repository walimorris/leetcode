/**
 * Implement the class ProductOfNumbers that supports two methods: 
 * 
 * 1. add(int num) : Adds the number num to the back of the current 
 *    list of numbers.
 *
 * 2. getProduct(int k) : Returns the product of the last k numbers in 
 *    the current list. You can assume that always the current list has
 *    at least k numbers. 
 *
 * At any time, the product of any contiguous sequence of numbers will fit 
 * into a 32-bit integer without overflowing. 
 * 
 * ProducsOfNumbers object will be instantiated and called as such : 
 * ProductOfNumbers obj = new ProductOfNumbers(); 
 * obj.add(num); 
 * int param_2 = obj.getProduct(k); 
 *
 * @author Wali Morris <walimmorris@gmail.com>
 */

class ProductOfNumbers {
    private int[] elements; // array structure to hold values 
    private int size; // field to hold the size of the array

    /**
     * One constraint to this problem was k shall be less than or 
     * equal to 40000. The max size of this array shall be 40000. 
     * Initializing size to 0 because no values are yet stored in 
     * this array.
     */
    public ProductOfNumbers() {
        this.elements = new int[40000];
        this.size = 0;
    }
    
    /**
     * Adds a integer to the back of array
     * @param num the number to add to array 
     */
    public void add(int num) {
        this.elements[size] = num;
        size++; // increment size when adding number
    }

    /**
     * multiplies the last k numbers in the array 
     * @param k describes how many numbers from the end 
     * of the array should be multiplied to get product
     * @return product of last k numbers in array
     */
    public int getProduct(int k) {
        int start = this.size - k; // index to start
        int product = 1;
        for ( int i = start; i < this.size; i++ ) {
            product *= this.elements[i];
        }
        return product;
    }
}

/* Given an array of integers, 1 < a[i] < n(n = size of array), some elements
 * appear twice and others appear once. Find all the elements that appear twice
 * in this array. 
 *
 * Note: This solution is slowed down because of sorting. After the sort, the 
 * run time is O(n). I will keep looking for a faster solution that takes 
 * less space. 
 *
 * Author : Wali Morris 
 * File   : Duplicates.java
 * Date   : 03/10/2020 
 */

import java.util.*; 

public class Duplicates { 
    public static void main(String[] args) { 
        int[] input = {4, 3, 2, 7, 8, 2, 3, 1}; 
        List<Integer> output = findDuplicates(input); 
        System.out.println(output); 
    } 

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>(); // create list 
        Arrays.sort(nums); // sort 
        for( int i = 0; i < nums.length-1; i++) { 
            if(nums[i + 1] == nums[i]) { // in duplicate, add duplicate to list 
                list.add(nums[i+1]); 
            } 
        } 
        return list; 
    } 
} 
