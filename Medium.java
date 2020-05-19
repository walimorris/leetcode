/** 
 * Please NOTE: Some of the solutions I've completed on Leetcode have implemented various algorithms. For instance, rather 
 * than just calling foo.sort(), I'll implement some sorting algorithm to work throughout the whole solution. This might be 
 * based on, say, a certain sorting algorithm that I know at that time and I view that as practice. I understand I'll take 
 * hits in areas on Leetcode that are evaluated, like time complexity, but I'm okay with that for now as long as I'm improving
 * while also asking myself questions like, "What sort method would be best here and why is this one so slow" and "why is this
 * solution so terrible!" All jokes aside, I understand that it would be easier, quicker, and arguably more productive to just
 * call an operation but my goal with leetcode boils down to improving my problem solving skills, algorithm and data 
 * structure implementation, as well as understanding when and where to use the right algorithms and data structures. Most 
 * importantly, my goal is to see improvement as I complete solutions. So, solutions completed 3 months from today should be 
 * better than solutions completed today. 
 * 
 * @author Wali Morris
 */

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
 * ProductOfNumbers object will be instantiated and called as such : 
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

/**
 * Given a non negative integer number 'num', for every number i in the range 0 to num 
 * calculate the number of 1's in their binary representation and return them as an 
 * array
 *
 * Note : Currently working on better solution. 
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class CountBits {
    public static void main(String[] args) {
        int[] output1 = countBits(2);
        int[] output2 = countBits(5);
        System.out.println(Arrays.toString(output1));
        System.out.println(Arrays.toString(output2));
    }
    
    public static int[] countBits(int num) {
        /* let's convert decimal to binary string representation. Because we have to examine every 
         * integer i from 0 < i < n we know, starting at 0 index, size of the array will be n+1
         */
        int[] output = new int[num+1];
        for (int i = num; i >= 0; i-- ) { // start at the given integer num
            int n = i;
            int count = 0; // record every 1 in binary representation of n  
            while ( n > 0) {
                int r = n % 2; // remainder is either 0 or 1
                if ( r == 1 ) {
                    count++; // remainer is 1, increment count
                }
                n = (int)Math.floor(n / 2); // get the quotient to continue
            }
            output[i] = count; // put count in array 
        }
        return output;
    }
}

/**
 * Rearrange Words in a Sentence 
 *
 * Given a sentence text (A sentence is a string of space-separated words) in the following format:
 *
 *
 *   First letter is in upper case
 *   Each word in text are separated by a single space
 *
 * Your task is to rearrange the words in text such that all words are rearranged in an increasing  
 * order of their lengths, If two words have the same length, arrange them in their original order
 * 
 * Return the new text following the format shown above
 *
 * Currently, my method is having trouble arranging some Strings of the same length in orginal order
 *
 * @author Wali Morris
 * @since 05/16/2020
 */

import java.util.*; 

public class RearrangeWords { 
    public static void main(String[] args) { 
        String input1 = "Keep calm and code on"; 
        String input2 = "Leetcode is cool"; 
        String input3 = "To be or not to be"; 
        String output1 = arrangeWords(input1); 
        String output2 = arrangeWords(input2);
        String output3 = arrangeWords(input3);
        System.out.println(output1); 
        System.out.println(output2);
        System.out.println(output3);
    }
    
    public static String arrangeWords(String text) {
        String text2 = text.toLowerCase();  
        String[] words = text2.split(" "); 
        for (int i = 0; i < words.length - 1; i++ ) { 
            String smallest = words[i]; 
            for ( int j = i + 1; j <  words.length; j++ ) {                 
                if ( words[j].length() < words[i].length() ) {
                    smallest = words[j];        
                    String temp = words[i]; 
                    words[i] = words[j]; 
                    words[j] = temp;    
                } 
            } 
        } 
        String sentence = ""; 
        for ( String word: words) { 
            sentence += word + " "; 
        }       
        return sentence.substring(0, 1).toUpperCase() + sentence.substring(1); 
    }
}
