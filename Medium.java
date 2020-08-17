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
 * Majority Element 2
 *
 * Given an integer array of size n, find all elements that appear more than n / 3 times
 *
 * The algorithm should run in linear time and in 0(1) space
 *
 * @author Wali Morris 
 * @since 05/22/2020
 */

import java.util.*; 

public class MajorityElement2 { 
    public static void main(String[] args) { 
        int[] input1 = {3, 2, 3}; 
        int[] input2 = {1, 1, 1, 3, 3, 2, 2, 2};
        int[] input3 = {1, 2}; 
        int[] input4 = {2, 2};  
        List<Integer> output1 = majorityElement(input1); 
        List<Integer> output2 = majorityElement(input2);
        List<Integer> output3 = majorityElement(input3);
        List<Integer> output4 = majorityElement(input4);
        System.out.println(Arrays.toString(input1) + " Majority Element: " + output1); 
        System.out.println(Arrays.toString(input2) + " Majority Element: " + output2);
        System.out.println(Arrays.toString(input3) + " Majority Element: " + output3);
        System.out.println(Arrays.toString(input4) + " Majority Element: " + output4);
    } 
    
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> majorityElementsList = new ArrayList<>();  
        // in the case nums contains only 1 element 
        if ( nums.length == 1 ) { 
            majorityElementsList.add(nums[0]); 
            return majorityElementsList; 
        }
        /* create a map to map the count of each element from nums then add each element
         * from nums > nums.length / 3 */
        Map<Integer, Integer> numsCount = new HashMap<>();
        for ( Integer n : nums ) {
            if ( numsCount.containsKey(n) ) { // does map contain element? 
                int count = numsCount.get(n) + 1; // yes, increment element's count
                /* elements count > nums.length / 3 and element is not in majority list? */
                if ( count > nums.length / 3 && majorityElementsList.contains(n) == false ) {
                    majorityElementsList.add(n); // yes, add element to majority list
                } else {
                    numsCount.put(n, count); // no, put element and new count back into map
                }
            } else {
                numsCount.put(n, 1); // element is not in map, add it and a count of 1
                if ( 1 > nums.length / 3 ) { // is this element's count > nums.length / 3?
                    majorityElementsList.add(n); // yes? add it to majority list
                }
            }
        }
        return majorityElementsList;
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

/**
 * Find the Duplicate Number 
 *
 * Given an array nums containing n + 1 integers where each integer is 
 * between 1 and n (inclusive), prove that at least one duplicate number
 * must exist
 *
 * Assume there is only one duplicate number, find the duplicate one
 *
 * @author Wali Morris
 * @since 05/24/2020
 */

import java.util.*;

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] input1 = {1, 3, 4, 2, 2};
        int[] input2 = {3, 1, 3, 4, 2};
        int output1 = findDuplicate(input1);
        int output2 = findDuplicate(input2);
        System.out.println(Arrays.toString(input1) + ": " + output1);
        System.out.println(Arrays.toString(input2) + ": " + output2);
    }
    
    public static int findDuplicate(int[] nums) {
        /* A map to hold each element in num and it's count */
        Map<Integer, Integer> numsCountList = new HashMap<>(); 
        for ( int n : nums ) { // iterate the elements in num
            if ( numsCountList.containsKey(n) ) { // element is in list, it has already been seen
                return n; // this is a duplicate, return element
            } else { // element has not yet been seen 
                numsCountList.put(n, 1); // add it to list, with count of 1
            } 
        } 
        return - 1; // returns -1 if there are no duplicates
    } 
}

/**
 * Daily Temperatures
 *
 * Given a list of daily temperatures T, return a list such that, for each day 
 * in the input, tells you how many days you would have to wait until a warmer 
 * temperature
 *
 * If there are no future day for which this is possible, put 0 instead
 *
 * @author Wali Morris 
 * @since 05/24/2020
 */

import java.util.*;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] input1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] output1 = dailyTemperatures(input1);
        System.out.println(Arrays.toString(input1) + " -> " +
                           Arrays.toString(output1));
    }
    
    public static int[] dailyTemperatures(int[] T) {
        /* holds T[i]'s number of days until warmer weather */
        int[] warmerT = new int[T.length];
        int size = 0; // holds index in place to input count of days to next weather at warmerT[size]
        for ( int i = 0; i < T.length - 1; i++ ) {
            // counts number of days from T[i](original temp) - T[j](warmer temp)
            int count = 0; // days 0
            int temp = T[i]; // current temperature  
            for (int j = i + 1; j < T.length; j++ ) {
                count++; // counts days until a temperature higher than current temp 
                int nextTemp = T[j]; // next days temp  
                if ( nextTemp > temp ) { // next days temp higher than current temp?
                    warmerT[size] = count; // put count into warmerT[size] 
                    break; // no need to continue searching, break inner loop
                } else {
                    warmerT[size] = 0; // higher temp was not found, put 0 in warmerT[size] 
                }
            }
            size++; // increment size to go to next index 
        }
        return warmerT;
    }
}

/**
 * Next Greater Node in Linked List
 *
 * We are given a linked list with head as the first node
 * Let's number the nodes in the list: node_1, node_2, node_3 etc
 *
 * Each node may have a next larger value for node_i, next_larger(node_i.val)
 * such that j greater than i, node_j.val greater than node_i.val, and j is 
 * the smallest possible choice (if such a k exists, the next larger value is 0)
 *
 * Return an array of integers (answer), where answer[i] = next_larger(node_{i+1})
 *
 * @author Wali Morris 
 * @since 06/10/2020
 */

import java.util.*;

public class NextGreaterNode {
    public static void main(String[] args) {
        ListNode list = new ListNode(2, new ListNode(1, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(7, new ListNode(4,
                         new ListNode(3, new ListNode(5)))));
        int[] output1 = nextLargerNodes(list);
        int[] output2 = nextLargerNodes(list2);
        System.out.println(Arrays.toString(output1));
        System.out.println(Arrays.toString(output2));
    }
    
    public static int[] nextLargerNodes(ListNode head) {
        int count = 0;
        ListNode current = head;
        List<Integer> list = new ArrayList<>();
        // add node values to arraylist 
        while ( current != null ) {
            list.add(current.val);
            current = current.next;
        }
        // create array to iterate until greater element
        int[] arr = new int[list.size()];
        for ( Integer num : list ) {
            arr[count] = num;
            count++;
        }
        // array to hold greater element value 
        int[] greaterNodesList = new int[arr.length];
        for ( int i = 0; i < arr.length; i++ ) {
            int element = arr[i]; // current element
            for ( int j = i; j < arr.length; j++ ) {
                // iterate nested loop until greater element is found
                if (arr[j] > element ) {
                    // add greater element at index in greaterNodesList
                    greaterNodesList[i] = arr[j];
                    // end inner loop 
                    break;
                } else {
                    // no greater element was found add 0 to index in greaterNodesList
                    greaterNodesList[i] = 0;
                }
            }
        }
        return greaterNodesList;
    }
}

/**
 * Top K Frequent Elements 
 *
 * Given a non-empty array of integers, return the k most frequent elements
 *
 * @author Wali Morris 
 * @since 06/10/2020
 */

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] input1 = {1, 1, 1, 2, 2, 3};
        int[] input2 = {1};
        int[] output1 = topKFrequent(input1, 2);
        int[] output2 = topKFrequent(input2, 1);
        System.out.println(Arrays.toString(output1));
        System.out.println(Arrays.toString(output2));
    }
    
    public static int[] topKFrequent(int[] nums, int k) {
        /* A map to read the elements from nums will take O(n) time, using map methods
         * get and put are O(1) time and filling the map with each element is O(n) time */
        Map<Integer, Integer> elementsMap = new HashMap<>();
        for ( int n : nums ) {
            if ( elementsMap.containsKey(n) ) {
                int count = elementsMap.get(n) + 1;
                elementsMap.put(n, count);
            } else {
                elementsMap.put(n, 1);
            }
        }
        /* creates an ArrayList of all values and an Array to store the top values */
        Collection<Integer> tempValuesList = elementsMap.values();
        List<Integer> valuesList = new ArrayList<>(tempValuesList);
        Collections.sort(valuesList);
        int[] topKArray = new int[k];
        /* iterates the map and valuesList(backwards) until the top k elements are found */
        int count = 0; // pointer to the current index of topKArray
        for ( int i = valuesList.size() - 1; i > valuesList.size() - 1 - k; i-- ) {
            int element = valuesList.get(i); // top K element
            for ( Integer key : elementsMap.keySet() ) {
                if ( elementsMap.get(key).equals(element) ) {
                    /* puts the key of top k element in topKArray */
                    topKArray[count] = key;
                    elementsMap.remove(key); // removes key 
                    break;
                }
            }
            // goes to next index in topKArray
            count++;
        }
        return topKArray;
    }
}

/**
 * Kth Largest Element in an Array 
 *
 * Find the kth largest element in an unsorted array
 *
 * Note that is is the kth largest element in the 
 * sorted order, not the kth distinct element
 *
 * @author Wali Morris
 * @since 06/10/2020
 */

import java.util.*; 

public class KthLargest { 
    public static void main(String[] args) { 
        int[] input1 = {3, 2, 1, 5, 6, 4}; 
        int[] input2 = {3, 2, 3, 1, 2, 4, 5, 5, 6}; 
        int output1 = findKthLargest(input1, 2); 
        int output2 = findKthLargest(input2, 4);
        System.out.println(output1);
        System.out.println(output2);
    } 

    public static int findKthLargest(int[] nums, int k) { 
        Arrays.sort(nums); 
        return nums[nums.length - k]; 
    } 
}

package com.morris.LeetcodeChallenge;

import java.util.*;

/**
 * Top K Frequent Words
 *
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from the highest to lowest. If two words have
 * the same frequency, then the word with the lower alphabetical order comes first.
 *
 * @author Wali Morris
 * @since 07/31/2020
 */
public class Main {
    public static void main(String[] args) {
        String[] A = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] B = {"the", "day", "is", "sunny", "the", "the", "the",
                      "sunny", "is", "is"};
        List<String> outputA = topKFrequent(A, 2);
        List<String> outputB = topKFrequent(B, 4);
        System.out.println(outputA);
        System.out.println(outputB);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordMap = new TreeMap<>();
        List<String> wordList = new ArrayList<>();
        for ( String word : words ) {
            if (wordMap.containsKey(word)) {
                int count = wordMap.get(word) + 1;
                wordMap.put(word, count);
            } else {
                wordMap.put(word, 1);
            }
        }
        for ( int i = 0; i < k; i++ ) {
            for ( String word : wordMap.keySet() ) {
                int maxValue = Collections.max(wordMap.values());
                if (wordMap.get(word) == maxValue && wordList.size() < k) {
                    wordList.add(word);
                }
                if ( wordList.size() == k ) {
                    break;
                }
            }
            for ( String word : wordList ) {
                wordMap.remove(word);
            }
            if ( wordList.size() == k ) {
                break;
            }
        }
        return wordList;
    }
}

package com.morris.augustchallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Replace Words
 *
 * In English, we have a concept called root, which can be followed by some other words to form another word -
 * let's call this word successor. For example, the root an, followed by other, which can form another word 
 * another. Now, given a dictionary consisting of many roots and a sentence. You need to replace all the  
 * successor in the sentence with the root forming it. If a successor has many roots can form it, replace 
 * it with a root with the shortest length. You need to output the sentence after the replacement.
 *
 * @author Wali Morris
 * @since 08/12/2020
 */

public class Main {
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was ratted by the battery";
        String output = replaceWords(dict, sentence);
        System.out.println(output);
    }

    public static String replaceWords(List<String> dict, String sentence) {
        StringBuilder newSentence = new StringBuilder();
        String[] splitSentence = sentence.split(" ");
        /* Iterates each word in the sentence and initializes rootReplacement as the full word */ 
        for ( int i = 0; i < splitSentence.length; i++ ) {
            String rootReplacement = splitSentence[i];
            /* Iterates the dictionary and finds the word that's the root of rootReplacement, if not such
             * word exists, the original word in the sentence will be appended to the new sentence. Else 
             * the shortest root found in the dictionary will be replaced and appended in place of the 
             * original word in the sentence. 
             */
            for (int j = 0; j < dict.size(); j++) {
                String root = dict.get(j);
                if (rootReplacement.startsWith(root) && root.length() < rootReplacement.length() ) {
                    rootReplacement = root;
                }
            }
            /* if not the last word in the sentence append a space between words. */ 
            if (!(i == splitSentence.length - 1)) {
                newSentence.append(rootReplacement).append(" ");
            } else {
                /* If last word in sentence, do not append space at the end. */ 
                newSentence.append(rootReplacement);
            }
        }
        return newSentence.toString();
    }
}

package com.morris.augustchallenge;

import java.util.*;

/**
 * Sort Characters By Frequency
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * NOTE: This algorithm is slow. It'd be better to process the cases as the values are
 * found. 
 *
 * @author Wali Morris
 * @since 08/17/2020
 */

public class Main {
    public static void main(String[] args) {
        String A = "tree";
        String B = "cccaaa";
        String C = "Aabb";
        String outputA = frequencySort(A);
        String outputB = frequencySort(B);
        String outputC = frequencySort(C);
        System.out.println(outputA);
        System.out.println(outputB);
        System.out.println(outputC);
    }

    public static String frequencySort(String s) {
        if ( s.isEmpty() ) {
            return "";
        } 
        /* creates a map of characters and its count */ 
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                int value = map.get(key) + 1;
                map.put(key, value);
            } else {
                map.put(key, 1);
            }
        }
        /* gets the max value in the map and iterates the map keyset to find the character with the 
         * greatest value. This character is appended to the StringBuilder for the number of times 
         * it appears in the string. The max value is decremented and process continued. 
         */
        StringBuilder frequencyString = new StringBuilder();
        int maxValue = Collections.max(map.values());
        while (maxValue > 0) {
            for (char key : map.keySet()) {
                if (map.get(key) == maxValue) {
                    int j = 0;
                    while (j < maxValue) {
                        frequencyString.append(key);
                        j++;
                    }
                }
            }
            maxValue--;
        }
        return frequencyString.toString();
    }
}
