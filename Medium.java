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
