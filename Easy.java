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
 * @author Wali Morris<walimmorris@gmail.com>
 */

/**
 * Given a non-empty, singly linked list with head node "head", 
 * return a middle node of linked list
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 * Definition for singly-linked list
 *
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * NOTE: This solution works okay in Java because of garbage collection. 
 * When middleNode() function points to next node, deleting the preceding 
 * node, Java recognizes these deleted nodes are no longer in use and 
 * this memory will be freed up. This works fine in Java but may need 
 * better implementation in languages like C or C++
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        int listSize = getSize(head); // get the size of LinkedList 
        if ( listSize == 1 ) {
            return head; // lists of size 1 should be returned as is, no middle node
        }
        ListNode current = head;
        int i = 1;
        while ( i < listSize / 2 + 1 ) { // delete front of node until reach middle of list 
            current = current.next; // points to next node, deleting the preceding node 
            i++;
        }
        return current;
    }

    /* iterates through LinkedList and counts number of nodes */
    public static int getSize(ListNode list) {
        int count = 0;
        ListNode current = list;
        while(current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
}

/**
 * Given an array of Integers arr, write a function that returns true if
 * and only if the num of occurrences of each value in array is unique
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class UniqueNumOfOccurrences {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 2, 1, 1, 3};
        int[] input2 = {1, 2};
        int[] input3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        int[] input4 = {26,2,16,16,5,5,26,2,5,20,20,5,2,20,2,2,20,2,16,
                        20, 16,17,16,2,16,20,26,16};
        boolean output1 = uniqueOccurrences(input1);
        boolean output2 = uniqueOccurrences(input2);
        boolean output3 = uniqueOccurrences(input3);
        boolean output4 = uniqueOccurrences(input4);
        System.out.println(Arrays.toString(input1) + ": " + output1);
        System.out.println(Arrays.toString(input2) + ": " + output2);
        System.out.println(Arrays.toString(input3) + ": " + output3);
        System.out.println(Arrays.toString(input4) + ": " + output4);
    }
    
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        /* count number of occurrences for a each num in a and store in Map */
        for ( int i = 0; i < arr.length; i++) {
            if ( numberMap.containsKey(arr[i]) ) {
                int val = numberMap.get(arr[i]);
                numberMap.put(arr[i], val+1);
            } else {
                numberMap.put(arr[i], 1);
            }
        }
        /* get collection of values, dump into set and compare size */
        Collection<Integer> valuesList = numberMap.values();
        Set<Integer> valuesSet = new HashSet<>(valuesList);
        if (valuesSet.size() == valuesList.size() ) {
            return true;
        }
        return false;
    }
}

/* In a array A of size 2N, there are N+1 unique elements, and exactly one of 
 * these elements is repeated N times. Return the element repeated N times. 
 *
 * Author : Wali Morris 
 * File   : RepeatedN.java
 * Date   : 4/01/2020
 *
 * NOTES  : This algorithm initializes a HashMap data structure to hold key value pairs. 
 *          To implement this data structure and find the repeated number we must iterate
 *          through the given array. In this case the key in the map is the integer value 
 *          from the array and the key-value is the number of times the key is seen within
 *          the array, this is initialized as count. If the key already exists within the 
 *          map, this means this is the repeated key, so return this key. If there are no 
 *          repeated keys, this repeatedN() will return 0. The time complexity of this 
 *          algorithm is O(N) because we are iterating through each value N of the array 
 *          only once. The worse case is O(N) because we may have to iterate through every 
 *          value before we find a repeated value N.
 */

import java.util.*;

public class RepeatedN {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 3};
        int output = repeatedN(input);
        System.out.println("The repeated element is: " + output);
    }
    
    public static int repeatedN(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int num : array ) { // iterate values in array    
            int key = num; // every number in array, call it key
            int count = 1;  // give this key a count equal to 1
            if ( map.containsKey(key) ) { // check the map, does it already contain this key?
                return key; // yes? This key is repeated, return this key
            } else {
                map.put(key, count); // no, put this key in map, with value of count
            }
        }
        return 0; // there are no repeated numbers 
    }
}

/* Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1. 
 * The linked list holds the binary representation of a number. 
 * Return the decimal value of the number in the linked list. 
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 *
 * Author : Wali Morris 
 * File   : ConvertBinary.java
 * Date   : 03/10/2020
 */

import java.util.*;

public class ConvertBinary {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));
        int output = getDecimalValue(head);
        System.out.println("result: " + output);
    }

    public static int getDecimalValue(ListNode head) {
        ListNode current = head; // current refers to ListNode head 
        Stack<Integer> keys = new Stack<>(); // create stack to use LIFO convention
        while ( current != null ) {
            keys.add(current.val); // populate stack
            current = current.next;
        }

        /* Binary sequences are read from left to right start at 2^0 to 2^lengthi-1 of sequence.
         * Reading the sequence in reverse due to stack we can subtract 1 from count, accounting
         * for 0 indexing. Ignore all zeros in binary sequence and only account for the 1's. 
         * Adding this gives the decimal value of the sequence. 
         */
        int count = keys.size() - 1;
        int decimal = 0;        
        for ( Integer key: keys ) {
            if ( key == 0 ) { 
                count--;  
                continue;  
            } else { 
                decimal += Math.pow(2, count); 
            } 
            count--; 
        }
        return decimal; 
    } 
} 

/* Given a sorted(in ascending order) integer array nums of n elements 
 * and a target value, write a function to search target in nums. If 
 * target exists, then return its index, otherwise return -1
 *
 * Author : Wali Morris 
 * File   : BinarySearch.java
 * Date   : 03/04/2020
 */

public class BinarySearch {
    public static void main(String[] args) {
        // test 1
        int[] input1 = {-1, 0, 3, 5, 9, 12};
        int key1 = 9;
        int output1 = search(input1, key1);
        System.out.println("Key is at index: " + output1);

        // test 2
        int[] input2 = {-1, 0, 3, 5, 9, 12};
        int key2 = 2;
        int output2 = search(input2, key2);
        System.out.println("Key is at index: " + output2);

        // test 3
        int[] input3 = {1, 4, 7, 9, 11, 13, 15, 16, 21, 55, 66, 68, 99, 123, 156, 202};
        int key3 = 21;
        int output3 = search(input3, key3);
        System.out.println("Key is at index: " + output3);
    }

    public static int search(int[] nums, int key) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (high + low) / 2;
            if( nums[mid] == key) {
                return mid;
            } else if(key < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

/* We are given a list nums of integers representing a list compressed with 
 * run-length encoding. Consider each adjacent pair of elements. For each such
 * pair, there are freq elements with value concatenated in sublist. Concatenate
 * all the sublists from left to right to generate the decompressed list. 
 * Return the decompressed list. 
 *
 * Author : Wali Morris 
 * File   : Decompress.java
 * Date   : 03/07/2020
 */

import java.util.*;

import java.util.*;

// A client program to test Decompress method
public class Decompress {
    public static void main(String[] args) {
        // test 1
        int[] input1 = {1, 2, 3, 4};
        int[] output1 = decompressList(input1);
        System.out.println(Arrays.toString(output1));
        // test2 
        int[] input2 = {1, 1, 2, 3};
        int[] output2 = decompressList(input2);
        System.out.println(Arrays.toString(output2));
    }
    
    public static int[] decompressList(int[] compressedList) {
        if ( compressedList.length % 2 != 0 ) {
            throw new IllegalArgumentException("List is unbalanced");
        }
        ArrayList<Integer> valueList = new ArrayList<>();
        for ( int i = 0; i < compressedList.length-1; i+=2) {
            int freq = compressedList[i];
            int value = compressedList[i+1];
            for (int j = 0; j < freq; j++) {
                valueList.add(value);
            }
        }
        int[] decompressedList = new int[valueList.size()];
        int k = 0;
        for ( int val: valueList ) {
            decompressedList[k] = val;
            k++;
        }
        return decompressedList;
    }
}

/* Given a binary matrix A, we want to flip the image horizontally, then 
 * invert it, and return the resulting image. 
 * A very awkward solution.
 *
 * Author : Wali Morris 
 * File   : FlipBinaryMatrix.java
 * Date   : 03/09/2020
 */

/* Given a m * n matrix grid which is sorted in non-decresing order both row-
 * wise and column-wise. return the number of negative numbers in grid. 
 *
 * Author : Wali Morris 
 * File   : NegativeMatrixNums.java
 * Date   : 03/11/2020
 */

import java.util.*;

public class NegativeMatrixNums {
    public static void main(String[] args) {
        int[][] input = new int[4][4];
        input[0][0] = 4;
        input[0][1] = 3;
        input[0][2] = 2;
        input[0][3] = -1;
        input[1][0] = 3;
        input[1][1] = 2;
        input[1][2] = 1;
        input[1][3] = -1;
        input[2][0] = 1;
        input[2][1] = 1;
        input[2][2] = -1;
        input[2][3] = -2;
        input[3][0] = -1;
        input[3][1] = -1;
        input[3][2] = -2;
        input[3][3] = -3;
        System.out.println("The array: " + Arrays.deepToString(input));
        int output = countNegatives(input);
        System.out.println("Negative Count: " + output );
    }
    
    public static int countNegatives(int[][] grid) {
        int count = 0;
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[i].length; j++ ) {
                if (grid[i][j] < 0 ) {
                    count++;
                }
            }
        }
        return count;
    }
}

import java.util.*;

public class FlipBinaryMatrix {
    // test case: pass  
    public static void main(String[] args) {
        int[][] input = new int[3][3];
        input[0][0] = 1;
        input[0][1] = 1;
        input[0][2] = 0;
        input[1][0] = 1;
        input[1][1] = 0;
        input[1][2] = 1;
        input[2][0] = 0;
        input[2][1] = 0;
        input[2][2] = 0;
        System.out.println("Original Matrix: " + Arrays.deepToString(input));
        int[][] myMatrix = flipAndInvert(input);
        System.out.println("Final Matrix: " + Arrays.deepToString(myMatrix));
    }

    public static int[][] flipAndInvert(int[][] a) {
        int[][] flippedMatrix = invert(a); // invert  
        int[][] finalMatrix = flip(flippedMatrix); // flip
        return finalMatrix;
    }
    
    public static int[][] flip(int[][] a) {
        // push reversed values onto stack 
        Stack<Integer> matrixKeys = new Stack<>();
        for ( int i = 0; i < a.length; i++) {
            for ( int j = a[i].length-1; j >= 0; j--) {
                matrixKeys.push(a[i][j]);
            }
        }
        // create new array and pop matrix keys to this array 
        int k = 0;
        int[][] flippedMatrix = new int[a.length][a[k].length];
        for ( k = 0; k < a.length; k++) {
            for( int n = 0; n < a[k].length; n++) {
                flippedMatrix[k][n] = matrixKeys.pop();
            }
        }
        return flippedMatrix;
    }
    
    public static int[][] invert(int[][] a) {
        // push inverted values onto stack 
        Stack<Integer> matrixKeys = new Stack<>();
        for ( int i = 0; i < a.length; i++) {
            for ( int j = 0; j < a[i].length; j++) {
                if ( a[i][j] == 0) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = 0;
                }
                matrixKeys.push(a[i][j]);
            }
        }
        // pop inverted values into new array 
        int i = 0;
        int[][] invertedMatrix = new int[a.length][a[i].length];
        for ( i = 0; i < a.length; i++) {
            for ( int j = 0; j < a[i].length; j++) {
                invertedMatrix[i][j] = matrixKeys.pop();
            }
        }
        return invertedMatrix;
    }
}

/* Given a non-negative integer num, return the number of steps 
 * to reduce it to zero. If the current number is even, you have 
 * to divide it by 2, otherwise, you have to subtract 1 from it.
 *
 * Author : Wali Morris
 * Date   : 02/28/2020
 * File   : ReduceZero.java
 */

class Solution {
    public int numberOfSteps (int num) {
        int count = 0;
        while(num > 0) {
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            count++;
        }
        return count;
    }
}

/* Given an array of integers, return indices of the two 
 * numbers such that they add up to a specific target.
 *
 * Author : Wali Morris 
 * File   : TwoSum.java
 * Date   : 02/28/2020
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int[] finalArr;
                if(nums[i] + nums[j] == target) {
                    return finalArr = new int[]{i, j};
                }
            }
        }
        return null;
    }
}

/* Given a valid (IPv4) IP address, return a defanged version of that IP 
 * address. A defanged IP address replaces every "." with "[.]"
 *
 * Author : Wali Morris
 * File   : Defang.java
 * Date   : 02/27/2020 
 */

public class Defang {
    public static void main(String[] args) {
        String address = "255.100.50.0";
        String returnAddr = defangIPaddr(address);
        System.out.println(returnAddr);
    }

    public static String defangIPaddr(String address) {
        String newAddr = "";
        for(int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.') {
                newAddr += "[.]";
                continue;
            }
            newAddr += address.charAt(i);
        }
        return newAddr;
    }
}

/* Given an array nums of integers, return how many of them contain 
 * an even number of digits. 
 *
 * Author : Wali Morris 
 * File   : EvenNumOfDigits.java 
 * Date   : 01/28/2020 
 */

public class EvenNumOfDigits {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        int result = findNumbers(nums);
        System.out.println("Result: " + result);
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        String numStr = "";
        for(int i = 0; i < nums.length; i++) {
            numStr = Integer.toString(nums[i]);
            if(numStr.length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}

/* You're given strings J representing the types of stones that
 * are jewels, and S representing the stones you have. Each 
 * character in S is a type of stone you have. You want to know 
 * how many of the stones you have are also jewels. 
 *
 * Author : Wali Morris
 * File   : JewelsAndStones.java
 * Date   : 02/28/2020
 */

public class JewelsAndStones {
    public static void main(String[] args) {
        // test 1
        String j = "aA";
        String s = "aAAbbbb";
        int jewels = jewelsInStones(j, s);
        System.out.println("Number of Jewels in Stone collection: " + jewels);

        // test 2
        String a  = "z";
        String b = "ZZ";
        int jewels1 = jewelsInStones(a, b);
        System.out.println("Number of Jewels in Stone collection: " + jewels1);
    }

    public static int jewelsInStones(String j, String s) {
        int jewels = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int k = 0; k < j.length(); k++) {
                if(s.charAt(i) == j.charAt(k)) {
                    jewels++;
                }
            }
        }
        return jewels;
    }
}

/* Given an integer number n, return the difference between the
 * product of its digits and the sum of its digits. 
 *
 * Author : Wali Morris 
 * File   : ProductAndSumi.java
 * Date   : 02/27/2020 
 */

class ProductAndSum {
    public static void main(String[] args) {
        // test 1
        int n = 234;
        int result1 = subtractProductAndSum(n);
        System.out.println("The Product - the sum of " + n + " is: " + result1);

        // test 2
        int m = 4421;
        int result2 = subtractProductAndSum(m);
        System.out.println("The Product - the sum of " + n + " is: " + result2);
    }

    public static int subtractProductAndSum(int n) {
        String numStr = Integer.toString(n);
        int product = 1;
        int sum = 0;
        int result;
        for(int i = 0; i < numStr.length(); i++) {
            product *= Character.getNumericValue(numStr.charAt(i));
            sum += Character.getNumericValue(numStr.charAt(i));
        }
        return result = product - sum;
    }
}

/* Implement function ToLowerCase() that has a string parameter str, and 
 * returns the same string in lowercase. 
 *
 * Author: Wali Morris
 * File  : ToLowerCase.java
 * Date  : 02/29/2020 
 */

public class ToLowerCase {
    public static void main(String[] args) {
        String input = "LOVELY";
        String output = toLowerCase(input);
        System.out.println("Output: " + output);
    }

    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }
}

/* Given an array of integers A sorted in non-decreasing order, return an array
 * of the squares of each number, also in sorted non-decresing order. 
 *
 * Author : Wali Morris
 * File   : SortedSquares.java
 * Date   : 02/29/2020 
 */

import java.util.*;

public class SortedSquares {
    public static void main(String[] args) {
        // test1
        int[] input1 = {-4, -1, 0, 3, 10};
        int[] output1 = sortedSquares(input1);
        System.out.println(Arrays.toString(output1));

        // test2
        int[] input2 = {-7, -3, 2, 3, 11};
        int[] output2 = sortedSquares(input2);
        System.out.println(Arrays.toString(output2));

    }
    
    public static int[] sortedSquares(int[] a) {
        int[] arr = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            arr[i] = a[i] * a[i]; // get the squares 
        }
        // compare each value for the length of array
        for(int j = 0; j < arr.length; j++) {
            for(int k = 0; k < arr.length; k++) {
                if(arr[k] > arr[j]) { // is value greater?
                    int temp = arr[j]; // yes? 
                    arr[j] = arr[k]; // move greater value to right
                    arr[k] = temp; // lesser value to left
                }
            }
        }
        return arr;
    }
}

/* Given an array A of non-negative integers, return an array consisting of all 
 * the even elements of A, followed by all the odd elements of A.
 *
 * Explain: This solution impliments a bubble sort algorithm. A given array can be 
 * unsorted, so we'll have to view every value in it. If the value being examined 
 * is not even sink it to the bottom of the list and move it right.   
 *
 * Author : Wali Morris 
 * File   : SortedParity.java
 * Date   : 02/29/2020 
 */

import java.util.*;

public class SortedParity {
    public static void main(String[] args) {
        // test 1
        int[] input1 = {3, 1, 2, 4};
        int[] output1 = sortArrayByParity(input1);
        System.out.println("Result: " + Arrays.toString(output1));

        // test 2
        int[] input2 = {11, 12, 10, 8, 22, 33, 44, 2, 1, 5, 6};
        int[] output2 = sortArrayByParity(input2);
        System.out.println("Result: " + Arrays.toString(output2));

    }

    public static int[] sortArrayByParity(int[] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length-1-i; j++) {
                if(a[j] % 2 != 0) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }
}

/* Given the array nums, for each nums[i] find out how many numbers in the 
 * array are smaller than it. 
 *
 * Author : Wali Morris 
 * File   : SmallerThanCurrent.java
 * Date   : 03/01/2020
 */

import java.util.*;

public class SmallerThanCurrent {
    public static void main(String[] args) {
        int[] input1 = {8, 1, 2, 2, 3};
        int[] output1 = smallerThanCurrent(input1);
        System.out.println("Result: " + Arrays.toString(output1));
    }

    public static int[] smallerThanCurrent(int[] a) {
        int[] newArr = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            int count = 0;
            for(int j = 0; j < a.length; j++) {
                if(a[i] > a[j]) {
                    count++;
                }
            }
            newArr[i] = count;
        }
        return newArr;
    }
}

/* Write a function that reverses a string. The input string is given as an 
 * array of characters char[]
 *
 * Do not allocate extra space for another array, you must do this by modifying 
 * the input array in-place with O(1) extra memory. 
 *
 * Author : Wali Morris 
 * File   : ReverseString.java
 * Date   : 03/02/2020
 */

import java.util.*;

class ReverseString {
    public static void main(String[] args) {
        char[] input1 = {'h', 'e', 'l', 'l', 'o'};
        reverseString(input1);
        char[] input2 = {'z', 'e', 'b', 'r', 'a'};
        reverseString(input2);
        char[] input3 = {'w', 'a', 't', 'e', 'r', 'b', 'o', 't', 't', 'l', 'e'};
        reverseString(input3);
    }
    /* eventually ints i and j will meet in the middle of string[int], at this point
     * all letters will have been replaced. Except for the middle letter. */
    public static void reverseString(char[] s) {
        int j = 0;
        for(int i = s.length - 1; i >= j; i--) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            j++;
        }
        System.out.println(Arrays.toString(s));
    }
}

* Given an array arr, replace every element in that array with the 
 * greatest element among the elements to its right, and replace the 
 * last element with -1
 *
 * Author : Wali Morris 
 * File   : ToTheRight.java
 * Date   : 03/03/2020
 */

import java.util.*;

public class ToTheRight {
    public static void main(String[] args) {
        // test 1 
        int[] input1 = {17, 18, 5, 4, 6, 1};
        int[] output1 = replaceElements(input1);
        System.out.println(Arrays.toString(output1));

        // test 2
        int[] input2 = {3, 4, 5, 1, 3, 1};
        int[] output2 = replaceElements(input2);
        System.out.println(Arrays.toString(output2));
    }
    
    public static int[] replaceElements(int[] a) {
        for(int i = 0; i < a.length-1; i++) {
            int key = a[i];
            for(int j = i+1; j < a.length; j++) {
                if(a[j] > key) {
                    key = a[j];
                }
            }
            a[i] = key;
            a[i+1] = 0;
        }
        a[a.length-1] = -1;
        return a;
    }
}

/* We are given two strings A and B. A shift on A consists of taking
 * string A and moving the leftmost character to the rightmost position.
 * Return true if and only if A can become B after some number of shifts
 * on A. 
 *
 * Author : Wali Morris 
 * File   : RotateString.java
 * Date   : 03/04/2020
 */

import java.util.*;

public class RotateString {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "cdeab";
        boolean output = rotateString(a, b);
        System.out.println("Output: " + output);

        String c = "abcde";
        String d = "abced";
        boolean output2 = rotateString(c, d);
        System.out.println("Output: " + output2);

        String e = "";
        String f = "";
        boolean output3 = rotateString(e, f);
        System.out.println("Output: " + output3);
    }
    
    public static boolean rotateString(String a, String b) {
        if(a.length() != b.length()) { // if string are equal continue, else they'll never match 
            return false;
        } else if(a.equals(b)) { // your lucky, strings already match, return true 
            return true;
        } else {
            // since strings are equal create char arrays for both strings
            char[] strA = new char[a.length()];
            char[] strB = new char[b.length()];
            for(int i = 0; i < a.length(); i++) {
                strA[i] = a.charAt(i);
                strB[i] = b.charAt(i);
            }
            char temp;
            int count = 0;
            while(count < strA.length) { // roatate all chars in the array
                temp = strA[0]; // hold first character in array
                for(int i = 0; i < strA.length - 1; i++) {
                    strA[i] = strA[i+1];  // rotate characters left
                }
                strA[strA.length-1] = temp; // append held character to end
                if(Arrays.equals(strA, strB)) { // do the arrays match?
                    return true;
                }
                count++;
            }
        }
        return false;
    }
}

/* Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * Return the maximum amount of splitted balanced strings. 
 *
 * Author : Wali Morris 
 * File   : BalancedStrings.java
 * Date   : 02/5/2020 
 */

import java.util.*;

public class BalancedStrings {
    public static void main(String[] args) {
        // test 1
        String a = "RLRRLLRLRL";
        int resultSequence1 = balancedStringSplit(a);
        System.out.println("How many balanced RL sequences are there: " + resultSequence1);

        // test 2
        String b = "RLLLLRRRLR";
        int resultSequence2 = balancedStringSplit(b);
        System.out.println("How many balanced RL sequences are there: " + resultSequence2);

        // test 3
        String c = "LLLLRRRR";
        int resultSequence3 = balancedStringSplit(c);
        System.out.println("How many balanced RL sequences are there: " + resultSequence3);

        // test 4
        String d = "RLRRRLLRLL";
        int resultSequence4 = balancedStringSplit(d);
        System.out.println("How many balanced RL sequences are there: " + resultSequence4);
    }
    
    public static int balancedStringSplit(String s) {
        StringBuffer str = new StringBuffer(s); // create new string buffer for insertion of comma
        int count = str.length(); // length will change, for equal sequences
        int rCount = 0;
        int lCount = 0;
        for(int i = 0; i < count-1; i++) {
            if(str.charAt(i) == 'L') {
                lCount++;
            } else if(str.charAt(i) == 'R') {
                 rCount++;
            }
            if(rCount == lCount) {
                str.insert(i+1, ","); // insert comma after RL sequence 
                i++; // increment i to account for "," insertion 
                count++; // increment count or length of str to account for "," insertion
                
                // restart 'R' and 'L' char counts      
                rCount = 0;
                lCount = 0;
            }
        }
        // use toString() method of String buffer object
        int numCommas = 0, j = 0;
        String newStr = str.toString() + ','; // comma signifies end of sequence
        System.out.print("Split: " + newStr + " ");
        while(j < newStr.length()) {
            if(newStr.charAt(j) == ',') { // every comma means there's a equal sequence 
                numCommas++;
            }
            j++;
        }
        return numCommas; // number of commas equals number of even RL sequences        
    }
}

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all 
 * elements in arr2 are also in arr1
 *
 * Sort the elements of arr1 such that the 
 * relative ordering of itmes in arr1 are the same as in arr2
 *
 * Elements that 
 * don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] input1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] input2 = {2, 1, 4, 3, 9, 6};
        int[] input3 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] input4 = {2, 42, 38, 0, 43, 21};
        int[] output = relativeSortArray(input1, input2);
        int[] output2 = relativeSortArray(input3, input4);
        System.out.println("Final Array: " + Arrays.toString(output));
        System.out.println("Final Array: " + Arrays.toString(output2));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> numbers = new HashMap<>(); // map to count occurances of each number in arrays
        ArrayList<Integer> list = new ArrayList<>(); // list to hold the numbers in arr1 that are in arr2
        ArrayList<Integer> list2 = new ArrayList<>(); // list to hold numbers in arr1 that are not in arr2
        for ( int num : arr1 ) { // count keys in arr1 and give a value for every occurance
            if ( numbers.containsKey(num) ) {
                int count = numbers.get(num);
                numbers.put(num, count + 1);
            } else {
                numbers.put(num, 1);
            }
        }
        /* Tree map sorts the keys so now we are in sorted order. At this 
         * point we will compare arr2, and our values in the TreeMap. If the 
         * value appears in arr2 we will store that value in a set for the 
         * number of times indicated by that keys value. The remaining keys 
         * are in sorted order and we will apend them to the end of the array.
         */

        for ( int n : arr2 ) {
            if ( numbers.containsKey(n) ) {
                for (int i = 0; i < numbers.get(n); i++ ) {
                    list.add(n);
                }
            }
        }
        // send numbers not in arr2 to list 2
        for ( int j : arr1 ) {
            if ( !list.contains(j) && !list2.contains(j) ) {
                for (int k = 0; k < numbers.get(j); k++ ) {
                    list2.add(j);
                }
            }
        }
        // sort list 2 before appending to list 1
        Collections.sort(list2);
        for ( int n : list2 ) {
            list.add(n);
        }
        // add the numbers in the set to final array
        Iterator<Integer> iter = list.iterator();
        int arrSize = list.size();
        int[] outputArr = new int[arrSize];
        int i = 0;
        while ( iter.hasNext() ) {
            int value = iter.next();
            outputArr[i] = value;
            i++;
        }
        return outputArr;
    }
}

/**
 * Given an array of intergers arr, a lucky integer is an integer which has a 
 * frequency in the array equal to its value 
 *
 * Return a lucky integer in the array
 *
 * If there are multiple lucky integers return the largest of them
 * If there is no lucky integer return -1
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class LuckyInteger {
    public static void main(String[] args) {
        int[] input1 = {2, 2, 3, 4};
        int[] input2 = {1, 2, 2, 3, 3, 3};
        int[] input3 = {2, 2, 2, 3, 3};
        int[] input4 = {5};
        int[] input5 = {7, 7, 7, 7, 7, 7, 7};
        int output1 = findLucky(input1);
        int output2 = findLucky(input2);
        int output3 = findLucky(input3);
        int output4 = findLucky(input4);
        int output5 = findLucky(input5);
        System.out.println(Arrays.toString(input1) + ": " + output1);
        System.out.println(Arrays.toString(input2) + ": " + output2);
        System.out.println(Arrays.toString(input3) + ": " + output3);
        System.out.println(Arrays.toString(input4) + ": " + output4);
        System.out.println(Arrays.toString(input5) + ": " + output5);
    }
    public static int findLucky(int[] array) {
        ArrayList<Integer> luckyList = new ArrayList<>(); // holds lucky numbers
        Map<Integer, Integer> luckyMap = new HashMap<>(); // count of numbers
        for ( int n : array ) { // iterate array to store key: value pairs in hashmap
            if ( luckyMap.containsKey(n) ) { // map contains n?
                int count = luckyMap.get(n); // yes. increase key's value count by 1
                luckyMap.put(n, count+1); // store key:value back into map
            } else {
                luckyMap.put(n, 1); // no. store new key(n) and value 1
            }
        }
        // find lucky numbers to store in lucky list
        for ( int key : luckyMap.keySet() ) { // iterate luckyMap's keys
            int value = luckyMap.get(key); // get each keys value
            if ( value == key ) { // are value and key equal?
                luckyList.add(key); // yes, add key to luckyList
            }
        }
        if ( luckyList.size() == 1 ) {
            return luckyList.get(0); // return only value in lucky list 
        } else {
            if (luckyList.size() > 1 ) {  // get the greatest value in lucky list 
                int greatestNum = luckyList.get(0);
                for ( int num : luckyList ) {
                    if ( num > greatestNum ) {
                        greatestNum = num;
                    }
                }
                return greatestNum;
            }
        }
        return -1; // no value, return -1 
    }
}

/**
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order. 
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class ReverseWord3 {
    public static void main(String[] args) {
        String input = "Let's take Leetcode contest";
        String output = reverseWords(input);
        System.out.println(output);
    }

    public static String reverseWords(String s) {
        String[] split = s.split("\\s");
        List<String> words = new ArrayList<>();
        for (int i = 0; i < split.length; i++ ) {
            words.add(split[i]); // add each split word into an ArrayLIst
        }
        String reverse = "";
        for ( int i = 0; i < words.size(); i++ ) { // get each split word from list and concatenate it's reverse
            String str = words.get(i);
            String reversedStr = reverseSingleWord(str);
            if ( i < words.size() - 1 ) {
                 reverse += reversedStr + " ";
            } else { // don't add space at the end of reverse String
                 reverse += reversedStr;
            }
        }
        return reverse;
    }
    
    /* helper function to reverse individual words from String */
    public static String reverseSingleWord(String word) {
        String finishedWord = "";
        Stack<Character> str = new Stack<>();
        for(int i = 0; i < word.length(); i++ ) {
            char n = word.charAt(i);
            str.push(n); // push onto stack 
        }
        while (!str.isEmpty()) { // reverse order of String
            char p = str.pop();
            finishedWord += p;
        }
        return finishedWord;
    }
}

/**
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the 
 * matrix in any order
 *
 * A lucky number is an element of the matrix such that it is the minimum 
 * element in its row and maximum in its column 
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class LuckyMatrixNumber {
    public static void main(String[] args) {
        int[][] input = new int[3][4];
        input[0][0] = 1;
        input[0][1] = 10;
        input[0][2] = 4;
        input[0][3] = 2;
        input[1][0] = 9;
        input[1][1] = 3;
        input[1][2] = 8;
        input[1][3] = 7;
        input[2][0] = 15;
        input[2][1] = 16;
        input[2][2] = 17;
        input[2][3] = 12;
        List<Integer> output = luckyNumbers(input);
        System.out.println(output);
    }
    
    public static List<Integer> luckyNumbers(int[][] matrix) {
        /* rowLow : stores lowest numbers in each row
         * columnHigh : stores highest numbers each column 
         */
        List<Integer> rowLow = new ArrayList<>();
        List<Integer> columnHigh = new ArrayList<>();
        // find the lowest number in each row
        for (int i = 0; i < matrix.length; i++) {
            int least = matrix[i][0]; // least begins as first nnumber in each row
            for (int j = 0; j < matrix[i].length; j++) {  // iterate each number in row
                int rowNum = matrix[i][j];
                if (rowNum < least) {
                    least = rowNum;// lowest number in row becomes least
                }
            }
            rowLow.add(least); // add lowest number of each row to rowLow list          
        }
        // find the highest numbers in each column
        int k = 0;
        /* case: this while loop assumes all rows in any matrix is the same length */
        while (k < matrix[0].length) { // while k is less than length of each row in matrix
            int highCol = matrix[0][k];// highest number in column begins as the first number in each column    
            for (int i = 0; i < matrix.length; i++) { // iterate for the length of column 
                int colNum = matrix[i][k];
                if (colNum > highCol) {
                    highCol = colNum; // highest number in column becomes highCol
                }
            }
            columnHigh.add(highCol); // add highest number of each column 
            k++;
        }
        /* take rowLow list and dump into a new set, create a new array to store lucky numbers,
         * compare numbers in columnHigh array list to the numbers in row Set. If the columnHigh
         * number is found in row Set, store as a lucky number
         */
        Set<Integer> row = new HashSet<>(rowLow);
        List<Integer> luckies = new ArrayList<>();
        for (Integer num : columnHigh) {
            if (row.contains(num) ) {
                luckies.add(num);
            }
        }
        return luckies;
    }
}
