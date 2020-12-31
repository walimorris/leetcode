/** 
 * NOTE: Some of the solutions I've completed on Leetcode have implemented various algorithms. For instance, rather 
 * than just calling foo.sort(), I'll implement some sorting algorithm to work throughout the whole solution. This might be 
 * based on, say, a certain sorting algorithm that I know at that time and I view that as practice. I understand I'll take 
 * hits in areas on Leetcode that are evaluated, like time complexity, but I'm okay with that for now as long as I'm improving
 * while also asking myself questions like, "What sort method would be best here and why is this one so slow" and "why is this
 * solution so terrible!" All jokes aside, I understand that it would be easier, quicker, and arguably more productive to just
 * call an operation but my goal with leetcode boils down to improving my problem solving skills, algorithm and data 
 * structure implementation, as well as understanding when and where to use the right algorithms and data structures. Most 
 * importantly, my goal is to see improvement as I complete solutions. So, solutions completed 3 months from today should be 
 * better than solutions completed today and I should gradually work my way through different levels of problems. 
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
 * @author Wali Morris
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

/** 
 * Given a string S of lowercase letters, a duplicate removal consists
 * of choosing two adjacent and equal letters, and removing them
 *
 * We repeatedly make duplicate removals on S until we no longer can 
 *
 * @return the final string after all such duplication removals have 
 * been made
 *
 * It's guaranteed the answer is unique 
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class AdjacentDuplicates {
    public static void main(String[] args) {
        String input1 = "abbaca";
        String input2 = "cxxaacy";
        String output1 = removeDuplicates(input1);
        String output2 = removeDuplicates(input2);
        System.out.println(output1);
        System.out.println(output2);
    }

    public static String removeDuplicates(String s) {
        if ( s.length() == 0 )
            return " "; // empty string, return empty string 
        boolean containsDuplicates = true;
        int count = 0;
        while ( containsDuplicates == true ) {
            /* iterate the string, find duplicates and remove as sub 
             * string, iterate count if this occurs */
            for ( int i = 0; i < s.length() - 1; i++ ) { 
                if ( s.charAt(i) == s.charAt(i+1) ) { 
                    String sub = String.valueOf(s.charAt(i)); 
                    sub += sub;
                    s = s.replaceFirst(sub, "");
                    count++;
                }
            }
            if ( count == 0 ) { // initiates flag and if true exits loop
                containsDuplicates = false;
            } else { // continues loop until no duplicates exist
                count = 0;
            }
        }
        return s;
    }
}

/**
 * Given two arrays of integers nums and index, create a target array 
 * 
 * Initially target array is empty
 * From left to right read nums[i] and index[i], insert at index index[i]
 * the value nums[i] in target array 
 *
 * @return The target array
 * 
 * @author Wali Morris 
 */

import java.util.*;

public class TargetArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        int[] output = createTargetArray(nums, index);
        System.out.println(Arrays.toString(output));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> target = new ArrayList<>();
        /* even in duplicate index[i], the List will be shifted right to 
         * compensate for new insertion */
        for(int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }
        // populate the final target array with items int items in list
        int[] target2 = new int[nums.length];
        for(int j = 0; j < nums.length; j++ ) {
            target2[j] = target.get(j);
        }
        return target2;
    }
}

/**
 * International Morse Code defines a standard encoding where each letter is 
 * mapped to a series of dots and dashes
 *
 * Given a list of words, each word can be written as a concatenation of the 
 * Morse code of each letter, this will be called a transformation of a word
 *
 * Return the number of different transformations among all words we have 
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

import java.util.*;

public class MorseCode {
    public static void main(String[] args) {
        String[] input = {"gin", "zen", "gig", "msg"};
        int output = uniqueMorseRepresentations(input);
        System.out.println(output);
    }

    public static int uniqueMorseRepresentations(String[] words) {
        /* Stores decoded map, this would preferrably come from an outside 
         * class rather than building in this method */
        Map<Character, String> codes = new HashMap<>(); 
        List<String> decodedList = new ArrayList<>();   
        String[] values = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", 
                          "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", 
                          "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                          "-.--", "--.."};      
        
        Character[] keys = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 
                              'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
                              'w', 'x', 'y', 'z'}; 

        int count = 0; 
        // Create code map 
        while( count < 0x1A ) { 
            codes.put(keys[count], values[count]); 
            count++; 
        }
        /* Views every String at words[index], iterates every character in that word, 
         * fetches the value mapped to this character and stores this decoded value
         * into a string */
        int wordsCounted = 0; 
        while( wordsCounted < words.length ) { 
            String decodedString = ""; 
            for ( int i = 0; i < words[wordsCounted].length(); i++ ) {  
                String decodedValue = codes.get(words[wordsCounted].charAt(i)); 
                decodedString += decodedValue;
            }
            decodedList.add(decodedString);  
            wordsCounted++; 
        } 
        /* Every decoded string is pushed to a set and if there are duplicates the 
         * string will be removed, revealing only unique decoded strings */
        Set<String> uniqueList = new HashSet<>(decodedList);
        System.out.println("Your decoded List: " + decodedList);
        System.out.println("Unique decoded List: " + uniqueList);
        return uniqueList.size();
    }
}

/** 
 * Given a string s you should reorder the string
 * 
 * @author Wali Morris 
 */

import java.util.*;

public class IncreasingDecreasingString {
    public static void main(String[] args) {
        String input1 = "aaaabbbbcccc";
        String input2 = "rat";
        String input3 = "leetcode";
        String output1 = sortString(input1);
        String output2 = sortString(input2);
        String output3 = sortString(input3);
        System.out.println("Result 1: " + output1);
        System.out.println("Result 2: " + output2);
        System.out.println("Result 3: " + output3);
    }

    public static String sortString(String s) {
        /* splits String s into an array of its individual letters. Counts 
         * the occurrance of each letter and appends letter and its count to 
         * letters Map in order of key */
        String[] str = s.split("");
        Map<String, Integer> letters = new TreeMap<>();
        for (String letter : str) {
            if ( letters.containsKey(letter) ) {
                int count = letters.get(letter);
                letters.put(letter, count+1);
            } else {
                letters.put(letter, 1);
            }
        }
        /* Rotates through key set and appends each letter to String str until 
         * every letter has a value of zero returning this version of a sorted
         * string */
        String sortedStr = ""; // here to append letters 
        Set<String> letterSet = letters.keySet();
        List<String> letterList = new ArrayList<>(letterSet);
        int appends = 0; // counts if there were any letters appended to str 
        boolean loop = true; // flag to release while loop 
        while ( loop ) {
            for ( int i = 0; i < letterList.size(); i++ ) {
                // grabs integer value of letter from letters Map
                String key = letterList.get(i);
                int value = letters.get(key);
                if ( value == 0 ) { // letter should not be appended to str
                    continue; // go to next 
                } else {
                    sortedStr += key;
                    letters.put(key, value-1); // decrease the value of letter
                    appends++;
                }
            }
            // this does everything from first for-loop, but in reverse 
            for (int j = letterList.size()-1; j >= 0; j--) {
                String keyReverse = letterList.get(j);
                int valueReverse = letters.get(keyReverse);
                if ( valueReverse == 0 ) {
                    continue;
                } else {
                    sortedStr += keyReverse;
                    letters.put(keyReverse, valueReverse-1);
                    appends++;
                }
            }
            if ( appends == 0 ) {
                loop = false; // there were no appends, release loop 
            } else {
                appends = 0; // there were still letters to append, loop again
            }
        }
        return sortedStr;
    }
}

/**
 *  Given a positive integer num consisting only of digits 6 and 9
 *
 *  Return the maximum number you can get by changing at most one digit 
 *  ( 6 becomes 9, and 9 becomes 6)
 *
 *  Note: Changing any digit to 6 will not create any number greater than it 
 *  was before flipping a 9 to a 6, therefore we will only flip 6's to 9's 
 *  and test for the greatest value after these flips
 *
 *  @author Wali Morris 
 *  @since 04/29/2020
 */


import java.util.*;

public class MaxNumber69 {
    public static void main(String[] args) {
        int input = 6996;
        int output = maximum69Number(input);
        System.out.println(output);
    }
    public static int maximum69Number(int num) {
        List<Character> numList = new ArrayList<>();
        if ( num == 9999 ) {
            return num;
        }
        int max = num; // the max number seen  
        String numStr = Integer.toString(num);
        /* Create an ArrayList containing the string digits of num */
        for ( int i = 0; i < numStr.length(); i++ ) {
            numList.add(numStr.charAt(i));
        }
        String potentialMaxStr = ""; // string to test greatest number 
        for ( int j = numList.size() - 1; j >= 0; j-- ) {
            /* iterate list, if a element is 6 then change it to 9 and build the
             * potentialMaxStr */
            if ( numList.get(j) == '6' ) {
                numList.set(j, '9');
                for ( Character n : numList ) {
                    potentialMaxStr += n;
                }
                /* if a 6 is flipped to 9 and is greater than the original 
                 * number, it becomes the max number. From here the 9 is 
                 * flipped back to 6 and comtinues iterating the list for 
                 * any other elements of 6*/
                if ( Integer.valueOf(potentialMaxStr) > max ) {
                    max = Integer.valueOf(potentialMaxStr);
                }
                numList.set(j, '6');
            }
            potentialMaxStr = ""; // restart test String
        }
        return max;
    }
}

/**
 * Kids With the Greatest Number of Candies 
 *
 * Given the array candies and the integer extraCandies, where candies[i] represents
 * the number of candies that the ith kid has 
 *
 * For each kid check if there is a way to distribute extraCandies among the kids 
 * such that he or she can have the greatest number of candies among them
 *
 * Notice: multiple kids can have the greatest number of candies 
 *
 * @author Wali Morris 
 * @since 05/07/2020
 */

import java.util.*;

public class Candies {
    public static void main(String[] args) {
        int[] candies1 = {2, 3, 5, 1, 3};
        List<Boolean> output1 = kidsWithCandies(candies1, 3);
        System.out.println(output1);
        int[] candies2 = {4, 2, 1, 1, 2};
        List<Boolean> output2 = kidsWithCandies(candies2, 1);
        System.out.println(output2);
        int[] candies3 = {12, 1, 12};
        List<Boolean> output3 = kidsWithCandies(candies3, 10);
        System.out.println(output3);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // holds true or false depending if ith kid will have most candies by adding extracandies to their count
        List<Boolean> truths = new LinkedList<>(); 
        int max = candies[0];
        for ( int candyCollection : candies ) { // find max pieces of candy 
            if ( candyCollection > max ) {
                max = candyCollection;
            }
        }
        /* add extra candy to each kids owed collection of candues, if adding extra sums to greater than the max 
         * owed candies the add true to truths list else add false */ 
        for ( int owedCandies : candies) {
            if ( owedCandies + extraCandies >= max ) {
                truths.add(true);
            } else {
                truths.add(false);
            }
        }
        return truths;
    }
}

/** 
 * Self Dividing Numbers
 *
 * A self-dividing number is a number that is divisible by every digit it contains
 * 
 * A self-dividing number is not allowed to contain any zeros 
 *
 * Given a lower bound and upper number bound, output a list of every possible self 
 * dividing number, including the bounds if possible
 *
 * @author Wali Morris 
 * @since 05/07/2020
 */

import java.util.*;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        List<Integer> output = selfDividingNumbers(1, 22);
        System.out.println(output);
    }
    /* This method iterates from left bound to right bound taking each number, converting it 
     * to its string version than isolating each digit and dividing it by the original number.
     * If at any point the number has a 0 digit or any digit is not self dividing, the loop 
     * breaks and goes to the next number. If all digits are self-dividing then the number is 
     * added to the self-dividing list. */
    public static List<Integer> selfDividingNumbers(int left, int right) { 
        List<Integer> selfDividingList = new ArrayList<>();
        for (int i = left; i <= right; i++ ) {
            String num = Integer.toString(i);   
            int counter = 0;
            boolean selfDividing = true;  
            while( counter < num.length() ) { 
                int digit = Integer.parseInt(Character.toString(num.charAt(counter))); 
                if ( digit == 0 ) {
                    selfDividing = false; 
                    break; 
                } else if ( !(i % digit == 0))  {
                    selfDividing = false;
                    break;
                } else {
                    counter++;
                }
            }
            if (selfDividing == true) {
                selfDividingList.add(i);
            }
        }
        return selfDividingList;
    }
}

/**
 * Unique Email Addresses
 *
 * Every email consists of a local name and a domain name, seperated by the "@" sign 
 * For example, in alice@leetcode.com, alice is the local name and leetcode.com is 
 * the domain name
 *
 * Beside lowercase letters, these emails may contain '.' s or '+' s
 *
 * If ou add periods ('.') between some characters in the local name part of the email 
 * address, mail sent there will be forwarded to the same address without dots in the 
 * local name: for example, "alicez@leetcide.com" forward to the same address. (This 
 * rule doesn't actually apply for domain names)
 *
 * If you add a plus ('+') in the local name, everything after the first plus sign will
 * be ignored. This allows certain emails to be filtered, for example: m.y+name@email.com
 * will be forwarded to my@email.com (Again, this does not actaully apply to domain names)
 *
 * It is possible to use both of these rules at the same time
 *
 * Given a list of emails, we need one email to each address in the list; figure out how many
 * different addresses actually receive mails
 *
 * @author Wali Morris
 * @since 05/07/2020
 */


import java.util.*; 

public class UniqueEmail { 
    public static void main(String[] args) { 
        String[] input = {"test.email+alex@leetcode.com", 
                          "test.e.mail+bob.cathy@leetcode.com", 
                          "testemail+david@lee.tcode.com"}; 
        int output = numUniqueEmails(input); 
        System.out.println(output); 
    } 
    
    /* In this method we initialize an empty String for every string in the array passed to this method. There 
     * are some rules to follow (read in the description and added as code to this method). If there are duplicate 
     * email address the Set will take care of this and eliminate any duplicates. We then return the number of emails 
     * left in the Set */
    public static int numUniqueEmails(String[] emails) { 
        // A set is used so we do not add duplicates email addresses to our final list 
        Set<String> emailList = new HashSet<>(); 
        for ( int i = 0; i < emails.length; i++ ) { // iterate each email address in the array 
            String emptyEmail = "";
            /* If the '@' sign is passed this will become true and we will no longer delete periods('.')
             * because we only delete periods in the local name. */
            boolean passedAt = false;    
            /* If we pass a '+' sign this will become true and will not add the characters between the + 
             * sign and the '@' sign */
            boolean plusSign = false; 
            for ( int j = 0; j < emails[i].length(); j++ ) { // iterate the characters in each email 
                if (emails[i].charAt(j) == '+' ) {
                    plusSign = true;
                    emptyEmail += "";
                } else if ( emails[i].charAt(j) == '@' ) {
                    passedAt = true;
                    emptyEmail += "@";
                } else if (emails[i].charAt(j) == '.' && passedAt == false ) {
                    emptyEmail += "";
                } else if ( passedAt == false && plusSign == true ) { // do not add characters between the + and @ sign 
                    emptyEmail += "";
                } else {
                    emptyEmail += emails[i].charAt(j);
                }
            }
            emailList.add(emptyEmail);
        }
        System.out.println(emailList);
        return emailList.size();
    }
} 

/** 
 * Robot Return to Origin
 *
 * There is a robot starting at (0, 0), the origin, on a 2D plane
 * 
 * Given a sequence of its moves, judge if this robot ends up at 
 * (0,0) after it completes its moves
 *
 * @author Wali Morris
 * @Since 05/11/2020
 */

import java.util.*;

public class RobotReturn {
    public static void main(String[] args) {
        String input1 = "UD";
        boolean output1 = judgeCircle(input1);
        System.out.println("Robot with UD returns to origin: " + output1);
        String input2 = "LL";
        boolean output2 = judgeCircle(input2);
        System.out.println("Robot with LL returns to origin: " + output2);
        String input3 = "RRDDLUUL";
        boolean output3 = judgeCircle(input3);
        System.out.println("Robot with RRDDLUUL returns to origin: " + output3);
        String input4 = "RRDD";
        boolean output4 = judgeCircle(input4);
        System.out.println("Robot with RRDD returns to origin: " + output4);
    }
    
    /* This method takes x and y, initialized to 0 acting as x, y horizontal and vertical
     * axis on 2D plane. For every positive or negative move (Left, right, up, down) the 
     * corresponsing x or y axis is affected. At the end of all moves, if x and y are both 
     * 0, then the moves end at (0, 0) origin. */
    public static boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for ( int i = 0; i < moves.length(); i++ ) {
            if (moves.charAt(i) == 'D' ) {
                y--;
            } else if (moves.charAt(i) == 'U' ) {
                y++;
            } else if (moves.charAt(i) == 'L' ) {
                x--;
            } else if (moves.charAt(i) == 'R' ) {
                x++;
            } else {
                throw new IllegalArgumentException("Illegal character move.");
            }
        }
        if ( x == 0 && y == 0 ) {
            return true;
        }
        return false;
    }
}

/** 
 * Single Number
 *
 * Given a non-empty array of integers, every element appears twice except for one
 *
 * Find that one
 *
 * @author Wali Morris 
 * @since 05/12/2020
 */

import java.util.*;

public class SingleNumber {
    public static void main(String[] args) {
        int[] input1 = {2, 2, 1};
        int output1 = singleNumber(input1);
        System.out.println(input1 + " single number: " + output1);
        int[] input2 = {4, 1, 2, 1, 2};
        int output2 = singleNumber(input2);
        System.out.println(input2 + " single number: " + output2);
    }

    /* This method stores each integer from the passed array into a map and counts the number 
     * of times that same integer has been seen within the array, this number is that integers
     * value. Next, the keySet is iterated and returns the integer from the array that is only 
     * seen once. If no such number exists, this method returns -1 */
    public static int singleNumber(int[] nums) { 
        Map<Integer, Integer> numMap = new HashMap<>(); 
        for ( int i = 0; i < nums.length; i++ ) { 
            if ( numMap.containsKey(nums[i]) ) { 
                int count = numMap.get(nums[i]);
                numMap.put(nums[i], count+1); 
            } else { 
                numMap.put(nums[i], 1); 
            } 
        }
        for (Integer key : numMap.keySet() ) {
            int value = numMap.get(key);
            if (value == 1) {
                return key;
            }
        }
        return -1;
    }
}

/**
 * Minimum Absolute Difference 
 *
 * Given an array of distinct integers arr, find all pairs of elements with the 
 * minimum absolute difference of any two elements 
 *
 * Return a list of pairs in ascending order(with respect to pairs)
 *
 * @author Wali Morris 
 * @since 05/13/2020
 */

import java.util.*;

public class AbsoluteDifference {
    public static void main(String[] args) {
        int[] input1 = {4, 2, 1, 3};
        List<List<Integer>> output1 = minimumAbsDifference(input1);
        System.out.println(output1);
        int[] input2 = {1, 3, 6, 10, 15};
        List<List<Integer>> output2 = minimumAbsDifference(input2);
        System.out.println(output2);
        int[] input3 = {3, 8, -10, 23, 19, -4, -14, 27};
        List<List<Integer>> output3 = minimumAbsDifference(input3);
        System.out.println(output3);
        int[] input4 = {-17, 46, 63, 81, -101, -91, 121, -2, 112, -15,
                        -65, -96, 6, -139};
        List<List<Integer>> output4 = minimumAbsDifference(input4);
        System.out.println(output4);
    }
    
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        /* holds all lists that meets requirements */
        List<List<Integer>> masterList = new ArrayList<>(); 
        /* Creates a list of the first two elements in the sorted array, these
         * elements correspond to the most likely minimum absolute values when 
         * subtracted, this list is then added to the master list */
        List<Integer> list = new ArrayList<>(
                        List.of(arr[0], arr[1]));
        masterList.add(list);
        int i = 1,  min = Math.abs(arr[0] - arr[1]);
        while ( i <= arr.length - 2) {
            List<Integer> softList = new ArrayList<>();
            int next = Math.abs(arr[i] - arr[i+1]);
            if ( next < min ) {
                masterList.clear(); // clears to store new minimum
                min = next;
                softList.add(arr[i]);
                softList.add(arr[i+1]);
                masterList.add(softList);
            } else {
                /* next equals minimum so we keep current softLists within masterList 
                 * and add the new softList to the masterList */
                if ( next == min ) {
                    softList.add(arr[i]);
                    softList.add(arr[i+1]);
                    masterList.add(softList);
                }
            }
            i++;
        }
        return masterList;
    }
}

/* Sort the Array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is 
 * even 
 *
 * You may return any answer array that satisfies this condition 
 *
 * @author Wali Morris 
 * @since 05/15/2020
 */

import java.util.*;

public class SortArrayParity2 {
    public static void main(String[] args) {
        int[] input1 = {4, 2, 5, 7};
        int[] output1 = sortArrayByParityII(input1);
        System.out.println(Arrays.toString(output1));
    }
    
    public static int[] sortArrayByParityII(int[] A) {
        /* two arrayLists: 1 holds positives and one holds negatives from Array A */
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        /* can hold same amount as array A */
        int[] B = new int[A.length];
        /* sends odds from A to oddList and evens to evenlist */
        for ( int num : A ) {
            if ( num % 2 == 0 ) { // num is even, send to even list
                evenList.add(num);
            } else {
                oddList.add(num); // num is odd, send to odd list
            }
        }
        /* Add first even number to B[0], remove even number from evenlist and begin adding
         * even and odd numbers to the corresponding even or odd index in array B until B is 
         * the same length as A */
        B[0] = evenList.get(0);
        evenList.remove(0);
        int count = 1;
        while ( count < A.length ) {
            /* if index at B is odd, add odd integer to index then remove the first
             * even number from oddList */
            if ( count % 2 == 0 ) {
                B[count] = evenList.get(0);
                evenList.remove(0);
            /* if index at B is even, add even integer to index then remove the first 
             * even number from evenList */
            } else {
                B[count] = oddList.get(0);
                oddList.remove(0);
            }
            count++; // go to next index  
        }
        return B; // return new array B
    }
}   

/**
 * Number of Students Doing Homework at a Given Time
 * 
 * Given two integer arrays startTime and endTime and given an integer queryTime
 *
 * The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i]
 *
 * Return the number of students doing their homework at time queryTime
 * More formally, return the number of students where queryTime lays in 
 * the interval [startTime[i], endTime[i]] inclusive
 *
 * @author Wali Morris
 * @since 05/16/2020
 */

import java.util.*; 

public class QueryTime { 
    public static void main(String[] args) { 
        int[] start = {9, 8, 7, 6, 5, 4, 3, 2, 1}; 
        int[] end = {10, 10, 10, 10, 10, 10, 10, 10, 10};
        int query = 5;
        int output = busyStudent(start, end, query); 
        System.out.println(output); 
    } 

    public static int busyStudent(int[] startTime, int[] endTime, int query) { 
        int busy = 0; 
        for (int i = 0; i < startTime.length; i++ ) { 
            if ( startTime[i] <= query && endTime[i] >= query ) { 
                busy++; 
            }
        } 
        return busy; 
    } 
}

/**
 * Rotate Array 
 *
 * Given an array, rotate the array to the right by k steps, where 
 * k is non-negative
 *
 * @author Wali Morris
 * @since 05/16/2020
 */


import java.util.*; 

public class RotateArray { 
    public static void main(String[] args) { 
        int[] input1 = {1, 2, 3, 4, 5, 6, 7}; 
        int k = 3; 
        rotate(input1, k); 
    }

    public static void rotate(int[] nums, int k) { 
        int rotations = 0;
        while ( !(rotations == k) ) {   
            int last = nums[nums.length - 1]; // record last num in array  
            for ( int i = nums.length - 1; i > 0; i-- ) { 
                nums[i] = nums[i-1]; // move each element to right 
            } 
             nums[0] = last; // first num in array equals last
            rotations++; // increment rotations(k)
        }
        System.out.println(Arrays.toString(nums)); 
    } 
}

/**
 * Length of Last Word 
 *
 * Given a String s consists of upper/lower-case alphabets and empty space characters ' ' 
 * return the length of the last word ( last word means the last appearing word if we loop
 * from left to right ) in the String
 *
 * If the last word does not exist return 0
 *
 * @author Wali Morris 
 * @since 05/20/2020
 */

import java.util.*;

public class LastWord {
    public static void main(String[] args) {
        String input1 = "Hello World";
        String input2 = " ";
        int output1 = lengthOfLastWord(input1);
        int output2 = lengthOfLastWord(input2);
        System.out.println("Length of " + input1 + " : " + output1);
        System.out.println("Length of " + input2 + " : " + output2);
    }

    public static int lengthOfLastWord(String s) {
        /* splitting string into array will split words into their own index based on were spaces 
         * are present in the string. If the string contains a space then the array will have a 
         * length of 0 */
        String[] wordArray = s.split(" ");
        if ( wordArray.length == 0 ) {
            return 0;
        } else { // return length of last string element in the array
            return wordArray[wordArray.length - 1].length();
        }
    }
}

/**
 * Destination City 
 *
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a
 * direct path going from cityAi to cityBi
 *
 * Return the destination city, that is, the city without any path outgoing to another 
 * city
 *
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, 
 * there will be exactly one destination city
 *
 * @author Wali Morris 
 * @since 05/21/2020
 */


import java.util.*;

public class DestinationCity {
    public static void main(String[] args) {
        List<String> inputList1 = new ArrayList<>(
                List.of("London", "New York"));
        List<String> inputList2 = new ArrayList<>(
                List.of("New York", "Lima"));
        List<String> inputList3 = new ArrayList<>(
                List.of("Lima", "Sao Paulo"));
        List<List<String>> input = new ArrayList<>(
                List.of(inputList1, inputList2, inputList3));
        String destination = destCity(input);
        System.out.println(input + " Destination: " + destination);
        List<String> input2List1 = new ArrayList<>(
                List.of("B", "C"));
        List<String> input2List2 = new ArrayList<>(
                List.of("D", "B"));
        List<String> input2List3 = new ArrayList<>(
                List.of("C", "A"));
        List<List<String>> input2 = new ArrayList<>(
                List.of(input2List1, input2List2, input2List3));
        String destination2 = destCity(input2);
        System.out.println(input2 + " Destination: " + destination2);
        List<String> input3List1 = new ArrayList<>(
                List.of("A", "Z"));
        List<List<String>> input3 = new ArrayList<>();
        input3.add(input3List1);
        String destination3 = destCity(input3);
        System.out.println(input3 + " Destination: " + destination3);
    }
    
    public static String destCity(List<List<String>> paths) {
        // returns the second city in single list of two cities 
        if ( paths.size() == 1 ) {
            return paths.get(0).get(1);
        }
        /* Creates a list to record the first city to begin. Also creates a map pair 
         * of the two cities in the original paths list. This way we can track travel 
         * from city A to city B */
        Map<String, String> cityPair = new HashMap<>();
        List<String> firstCity = new ArrayList<>();
        for ( List<String> cities : paths ) {
            cityPair.put(cities.get(0), cities.get(1));
            firstCity.add(cities.get(0));
        }
        boolean last = false;
        String finalCity = "";
        int start = 0;
        String current = firstCity.get(start); // start at first city 
        while (last == false) { // while we still have cities to travel to 
            if ( cityPair.containsKey(current) ) { // if destination city is also a departure city
                current = cityPair.get(current); // get the departure cities destination 
            } else {
                finalCity = current; // if destination city is not also a departure city
                last = true; // it's true, we've reached the final city
            }
        }
        return finalCity; // return destination city(final city) 
    }
}

/**
 * Decrypt String from Alphabet to Integer Mapping 
 *
 * Given a String s formed by digits ('0' - '9') and '#', we want to map s to English 
 * lowercase characters as follows: 
 *
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively 
 * characters ('j' to 'z') are represented by ('10#' to '26#') respectively 
 *
 * return the String formed after mapping and its guaranteed a unique mapping will 
 * always exist
 *
 * @author Wali Morris 
 * @since 05/22/2020
 */


import java.util.*; 

public class DecryptString { 
    public static void main(String[] args) { 
        String input1 = "10#11#12"; 
        String output1 = freqAlphabets(input1);
        String input2 = "1326#"; 
        String output2 = freqAlphabets(input2);
        String input3 = "25#"; 
        String output3 = freqAlphabets(input3);
        String input4 = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"; 
        String output4 = freqAlphabets(input4);         
        System.out.println(input1 + " -> " + output1);
        System.out.println(input2 + " -> " + output2);
        System.out.println(input3 + " -> " + output3);
        System.out.println(input4 + " -> " + output4);  
    } 
    
    public static String freqAlphabets(String s) {
        // Code Map holding key decryptions 
        Map<String, String> codeMap = new HashMap<>();
        codeMap.put("1", "a");
        codeMap.put("2", "b");
        codeMap.put("3", "c");
        codeMap.put("4", "d");
        codeMap.put("5", "e");
        codeMap.put("6", "f");
        codeMap.put("7", "g");
        codeMap.put("8", "h");
        codeMap.put("9", "i");
        codeMap.put("10#", "j");
        codeMap.put("11#", "k");
        codeMap.put("12#", "l");
        codeMap.put("13#", "m");
        codeMap.put("14#", "n");
        codeMap.put("15#", "o");
        codeMap.put("16#", "p");
        codeMap.put("17#", "q");
        codeMap.put("18#", "r");
        codeMap.put("19#", "s");
        codeMap.put("20#", "t");
        codeMap.put("21#", "u");
        codeMap.put("22#", "v");
        codeMap.put("23#", "w");
        codeMap.put("24#", "x");
        codeMap.put("25#", "y");
        codeMap.put("26#", "z");
        
        List<String> codes = new ArrayList<>(); // list holding single codes 
        for ( int i = s.length() - 1; i >= 0; i-- ) {
            /* collect the single digit and add to codes list */
            if ( !(s.charAt(i) == '#') ) {
                String code = "";
                code += s.charAt(i);
                codes.add(code);
            } else {
                /* A # symbol has been found and the next two digits after the # should 
                 * be collected together */
                if ( s.charAt(i) == '#' ) {
                    String code = "";
                    code += s.charAt(i-2);
                    code += s.charAt(i-1);
                    code += s.charAt(i);
                    codes.add(code);
                    i -= 2;
                }
            }
        }
        /* convert codes to String using code Map starting from last element in codes List */
        String decrytedStr = "";
        for ( int j = codes.size() - 1; j >= 0; j-- ) {
            String value = codeMap.get(codes.get(j));
            decrytedStr += value;
        }
        return decrytedStr;
    }
}       

/**
 * Majority Element 
 *
 * Given an array of size n, find the majority element, the majority element is 
 * the element that appears more than n/2 times
 *
 * You may assume that the array is non-empty and the majority element always 
 * exists in the array. 
 *
 * @author Wali Morris 
 * @since 05/22/2020
 */

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int[] input1 = {3,2,3};
        int[] input2 = {2,2,1,1,1,2,2};
        int output1 = majorityElement(input1);
        int output2 = majorityElement(input2);
        System.out.println(Arrays.toString(input1) + " Majority Element: " + output1);
        System.out.println(Arrays.toString(input2) + " Majority Element: " + output2);
    }
    
    public static int majorityElement(int[] nums) {
        // in the case there is only 1 element in nums
        if ( nums.length == 1 ) {
            return nums[0];
        }
        /* Create a Map to count the amount of each element, if a count breaks 
         * nums/2, return that element as majority element */
        Map<Integer, Integer> numsCount = new HashMap<>();
        for ( Integer n : nums ) {
            if ( numsCount.containsKey(n) ) { // map already contains element? 
                int count = numsCount.get(n) + 1; // increase element count by 1
                if ( count > nums.length / 2 ) { // is the count greater than nums/2?
                    return n; // return element
                } else {
                    numsCount.put(n, count); // count is not greater, put element back into map with new count
                }
            } else { // element does not exist
                numsCount.put(n, 1); // put element into map with starting count of 1
            }
        }
        return -1; // nums array does not meet criteria, return -1 
    }
}

/** 
 * Move Zeros 
 *
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements 
 *
 * @author Wali Morris 
 * @since 05/22/2020
 */

import java.util.*;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] input1 = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        System.out.print(Arrays.toString(input1) + " -> ");
        moveZeroes(input1);
        System.out.println(Arrays.toString(input1));
    }
    
    public static void moveZeroes(int[] nums) {
        // creates an ArrayList of nums to check if it contains a 0
        List<Integer> numsList = new ArrayList<>();
        for ( int n : nums ) {
            numsList.add(n);
        }
        // if nums contains a 0
        if ( numsList.contains(0)) {
            /* impliments a modified selection sort algorithm to move all 0's to the end of 
             * nums array. If the pointed to element is a 0 and the next element is either 
             * less than or greater than 0, swap until 0 element is at the end */
            for ( int i = 0; i < nums.length - 1; i++ ) {
                int current = i;
                for ( int j = i + 1; j < nums.length; j++ ) {
                    if (nums[current] == 0 && nums[j] > nums[current] ||
                        nums[current] == 0 && nums[j] < nums[current]) {
                        int temp = nums[j];
                        nums[j] = nums[current];
                        nums[current] = temp;
                    }
                }
            }
        }
    }
}

/**
 * Check if a word occurs as a Prefix of any word in a sentence 
 *
 * Given a sentence that consists of some words seperated by a single space, and a search word 
 *
 * You have to check if searchWord is a prefix of any word in the sentence
 *
 * Return the index of the word in sentence where searchWord is a Prefix of this word (1-indexed)
 *
 * If a searchWord is a prefix of more than one word, return the index of the first word and if 
 * there is no such word return -1
 *
 * @author Wali Morris 
 * @since 05/25/2020
 */

import java.util.*;

public class SentencePrefix {
    public static void main(String[] args) {
        String sentence1 = "i love eating burger";
        String sentence2 = "this problem is an easy problem";
        String sentence3 = "i am tired";
        String sentence4 = "i use triple pillow";
        String searchWord1 = "burg";
        String searchWord2 = "pro";
        String searchWord3 = "you";
        String searchWord4 = "pill";
        int output1 = isPreFixOfWord(sentence1, searchWord1);
        int output2 = isPreFixOfWord(sentence2, searchWord2);
        int output3 = isPreFixOfWord(sentence3, searchWord3);
        int output4 = isPreFixOfWord(sentence4, searchWord4);
        System.out.println(searchWord1 + " is prefix of word number : " + output1);
        System.out.println(searchWord2 + " is prefix of word number : " + output2);
        System.out.println(searchWord3 + " is prefix of word number : " + output3);
        System.out.println(searchWord4 + " is prefix of word number : " + output4);
    }
    
    public static int isPreFixOfWord(String sentence, String searchWord) {
        if ( sentence.equals(" ") ) {
            return -1; // empty sentence, return -1 
        }
        /* Array of elements consisting of each word in sentence */
        String[] sentenceArr = sentence.split(" ");
        /* get first letter of word being searched */
        char searchWordFirstLetter = searchWord.charAt(0);
        /* sequential search of any element in sentence array that contains the first letter of the 
         * searched word (only continues match if substring has length greater than or equal to 
         * searched word or else a runtime error will be thrown due to substring out of index) */
        for ( int i = 0; i < sentenceArr.length; i++ ) {
            if ( sentenceArr[i].charAt(0) == searchWordFirstLetter ) { // found a word with match 
                if( sentenceArr[i].length() >= searchWord.length() &&
                    sentenceArr[i].substring(0, searchWord.length()).equals(searchWord )) {
                    /* substring of word in sentence matches searched word, return index + 1 */
                    return i + 1;
                }
            }
        }
        return -1; // no prefix was found 
    }
}

/**
 * Given a String S and a Character C, return an array of integers representing the 
 * shortest distance from the Character C in the string
 *
 * @author Wali Morris 
 * @since 05/25/2020
 */

import java.util.*;

public class ShortestDistanceToChar {
    public static void main(String[] args) {
        String input1 = "loveleetcode";
        int[] output1 = shortestToChar(input1, 'e');
        System.out.println(Arrays.toString(output1));
    }
    
    public static int[] shortestToChar(String S, char C) {
        /* creates a list to hold the index of each element C in S */
        List<Integer> characterIndex = new ArrayList<>();
        for ( int i = 0; i < S.length(); i++ ) {
            if ( S.charAt(i) == C ) {
                characterIndex.add(i);
            }
        }
        /* Creates an array to hold the distance to the closest character C. If the index is less than 
         * s.length / 2 we get the distance from the furthest character C and current index. If the index
         * is greater than s.length / 2 we get the distance from the shortest distance C and current index.
         * This is done because we use Math.abs() */
        int[] distances = new int[S.length()];
        for ( int j = 0; j < S.length(); j++ ) {
            if ( j < S.length() / 2 ) {
                int smallestDistance = Math.abs(j - characterIndex.get(characterIndex.size() - 1));
            }
            int smallestDistance = Math.abs(j - characterIndex.get(0));
            /* collect the index of each Char C and test for shortest distance. Then add this shortest 
             * distance to distances[j] */
            for ( int k = 0; k < characterIndex.size(); k++ ) {
                int nextDistance = Math.abs(j - characterIndex.get(k));
                if ( nextDistance < smallestDistance ) {
                    smallestDistance = nextDistance;
                }
            }
            distances[j] = smallestDistance;
        }
        return distances;
    }
}

/**
 * Uncommon Words
 *
 * We are given two sentences A and B ( a sentence is a string of space seperated words, 
 * each word consists only of lowercase letters)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not 
 * appear in the other sentence 
 *
 * Return a list of all uncommon words
 *
 * Note: This method uses uses the idea of functional decomposition by breaking the program
 * into smaller methods to process the information
 *
 * @author Wali Morris
 * @since 05/26/2020
 */

import java.util.*;

public class UncommonWords {
    public static void main(String[] args) {
        String input1 = "this apple is sweet", input2 = "this apple is sour";
        String input3 = "apple apple", input4 = "bananna";
        String[] output1 = uncommonFromSentences(input1, input2);
        String[] output2 = uncommonFromSentences(input3, input4);
        System.out.println(Arrays.toString(output1));
        System.out.println(Arrays.toString(output2));
    }

    /* This method takes two seperate sentences and split them into two seperate arrays, giving
     * each element(word) its own index. The two sentences are then mapped by word and count. 
     * Both maps are then compared and populated into a their own list. If a word from map1 is 
     * not in map2 and that word is not repeated it's added to the list, and vice versa. These 
     * list are then combined and returned as an array of uncommon words */
    public static String[] uncommonFromSentences(String A, String B) {
        String[] sentenceA = A.split(" "), sentenceB = B.split(" ");
        Map<String, Integer> mapA = populateMapFromArray(sentenceA);
        Map<String, Integer> mapB = populateMapFromArray(sentenceB);
        List<String> uncommonWordsA = uncommonWordsFromStrings(mapA, mapB);
        List<String> uncommonWordsB = uncommonWordsFromStrings(mapB, mapA);
        uncommonWordsA.addAll(uncommonWordsB);
        String[] uncommonArray = new String[uncommonWordsA.size()];
        uncommonArray = uncommonWordsA.toArray(uncommonArray);
        return uncommonArray;
    }
    
    /* Takes an array of Strings as parameter and mapped by word and its count, returns the 
     * map */
    public static Map<String, Integer> populateMapFromArray(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for ( String word : arr ) {
            if ( map.containsKey(word) ) {
                int count = map.get(word) + 1;
                map.put(word, count);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }

    /* Takes two maps as parameters and compares for uncommon words, *see uncommonFromSentences()**/
    public static List<String> uncommonWordsFromStrings(Map<String, Integer> mapA,
                    Map<String, Integer> mapB) {
        List<String> s = new ArrayList<>();
        for ( String word : mapA.keySet() ) {
            if ( !(mapB.containsKey(word))) {
                if ( mapA.get(word) == 1 ) {
                    s.add(word);
                }
            }
        }
        return s;
    }
}

/** 
 * Next Greater Element I 
 *
 * You are given two arrays ( without duplicates) nums1 and nums2 where nums1's elements are 
 * subset of nums2 
 *
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in 
 * nums2
 *
 * If it does not exist, output -1 for this number
 *
 * @author Wali Morris 
 * @since 05/27/2020
 */

import java.util.*;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] input1 = {4, 1, 2}, input2 = {1, 3, 4, 2};
        int[] input3 = {2, 4}, input4 = {1, 2, 3, 4};
        int[] output1 = nextGreaterElement(input1, input2);
        int[] output2 = nextGreaterElement(input3, input4);
        System.out.println(Arrays.toString(output1));
        System.out.println(Arrays.toString(output2));
    }
    
    int[] nextGreaterElement1 = new int[nums1.length];
        for ( int i = 0; i < nums1.length; i++ ) {
            int current = nums1[i]; // number we are looking for in nums2 array  
            boolean currentFound = false; // checks if nums1[i] is found in nums2 
            boolean nextGreatestFound = false; // checks if a number greater than nums1[i] is found  
            int nextGreatestNum = 0; // the next greatest num to the right of nums1[i] found in nums2  
            for ( int j = 0; j < nums2.length; j++ ) {
                if ( nums2[j] == current ) {
                    currentFound = true; // number has been found 
                } else {
                    /* number from nums1 has been found in nums2 and there's a number greater than it 
                     * to the right of it in nums2 */
                    if ( nums2[j] > current && currentFound == true ) {
                        nextGreatestFound = true;
                        nextGreatestNum = nums2[j]; // the greater number to the right  
                        break;
                    }
                }
            }
            if ( nextGreatestFound == true ) { // if greatest has been found 
                nextGreaterElement1[i] = nextGreatestNum; // add greatestNum to array 
            } else {
                nextGreaterElement1[i] = -1; // else add -1
            }
        }
        return nextGreaterElement1;
    }
}

/**
 * Maximum Product of Two Elements in an Array 
 *
 * Given the array of integers nums, you will choose two different indices i and j 
 * of that array 
 *
 * Return the maximum value of (nums[i] - 1 * (nums[j] - 1)
 *
 * @author Wali Morris
 * @since 06/02/2020
 */

import java.util.*;

public class MaximumProduct {
    public static void main(String[] args) {
        int[] input1 = {3, 4, 5, 2};
        int[] input2 = {1, 5, 4, 5};
        int[] input3 = {3, 7};
        int output1 = maxProduct(input1);
        int output2 = maxProduct(input2);
        int output3 = maxProduct(input3);
        System.out.println("Max product of " + Arrays.toString(input1) + ": " + output1);
        System.out.println("Max product of " + Arrays.toString(input2) + ": " + output2);
        System.out.println("Max product of " + Arrays.toString(input3) + ": " + output3);
    }

    public static int maxProduct(int[] nums) {
        /* Creates a map to record each integer element and its count */
        Map<Integer, Integer> numsMap =  new HashMap<>();
        for ( int num : nums ) {
            if ( numsMap.containsKey(num) ) {
                int count = numsMap.get(num) + 1;
                numsMap.put(num, count);
            } else {
                numsMap.put(num, 1);
            }
        }

        /* gets the first and second greatest number, if the greatest number has a duplicate then the 
         * second greatest number has the same value */
        int firstGreatestNum = Collections.max(numsMap.keySet());
        int secondGreatestNum = 0;
        if ( numsMap.get(firstGreatestNum) > 1 ) {
            secondGreatestNum = firstGreatestNum;
        } else {
            numsMap.remove(firstGreatestNum);
            secondGreatestNum = Collections.max(numsMap.keySet());
        }
        // return the product 
        return ( (firstGreatestNum - 1) * (secondGreatestNum - 1));
    }
}

/**
 * Valid Palidrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters 
 * and ignoring cases
 *
 * For the purpose of this problem, we determine empty string as valid palindrome
 *
 * @author Wali Morris
 * @since 06/03/2020
 */

import java.util.*; 

public class ValidPalindrome { 
    public static void main(String[] args) { 
        String input1 = "A man, a plan, a canal: Panama"; 
        String input2 = "race a car";
        String input3 = "0P";   
        boolean output1 = isPalindrome(input1); 
        boolean output2 = isPalindrome(input2);
        boolean output3 = isPalindrome(input3);         
        System.out.println(output1); 
        System.out.println(output2); 
        System.out.println(output3); 
    } 
    
    public static boolean isPalindrome(String s) {
        boolean palindrome = true; 
        if ( s.length() == 0 ) { 
            return palindrome; 
        }  
        String s2 = s.toLowerCase();  
        Queue<Character> queue = new LinkedList<>(); 
        Stack<Character> stack = new Stack<>();
        
        /* iterates String s and pushes and adds only characters a - z or integers 0 - 9
         * to queue and stack */ 
        for ( int i = 0; i < s.length(); i++ ) {
            if ( s2.charAt(i) > 96 && s2.charAt(i) < 123 ||
                 s2.charAt(i) > 47 && s2.charAt(i) < 58 ) {
                queue.add(s2.charAt(i));
                stack.push(s2.charAt(i));
            }
        }
        /* Empties both stack and queue, comparing each element using FIFO/LIFO conventions. 
         * If any two elements do not match, return false else return true */
        while ( !queue.isEmpty() ) {
            char queueElement = queue.remove();
            char stackElement = stack.pop();
            if ( !(queueElement == stackElement) ) {
                return false;
            }
        }
        return palindrome;
    }
}

/* Given a string, you need to reverse the order of characters in each word 
 * within a sentence while still preserving whitespace and initial word 
 * order. 
 *
 * Note: This problem is similar, if not the same question, to Reverse String II
 * In this solution I use a nested loop to build the new sentence in reverse order
 * which seems to be much better solution. This solution can still be written in 
 * a much more proficient way
 *
 * Author : Wali Morris 
 * File   : ReverseStringIII.java
 * Date   : 06/05/2020
 */

import java.util.*;

public class ReverseStringIII {
    public static void main(String[] args) {
        String input = "Let's take LeetCode contest";
        String output = reverseWords(input);
        System.out.println(output);
    }
    
    public static String reverseWords(String s) {
        StringBuilder finalStr = new StringBuilder("");                 
        /* An array to split the sentence by each individual word */    
        String[] sentenceArray = s.split(" "); 
        /* This nested loop reads each element in sentence array and reverse that word then 
         * appends it to finalStr */
        for ( int i = 0; i < sentenceArray.length; i++ ) {
            String word = sentenceArray[i];     
            for ( int j = word.length() - 1; j >= 0; j-- ) { 
                finalStr.append(word.charAt(j)); 
            }           
            /* if the last word is being read do not append a space */
            if ( !(i == sentenceArray.length - 1) ) { 
                finalStr.append(" "); 
            }
        }
        return finalStr.toString();
    }
}

/**
 * Last Stone Weight
 *
 * We have a collection of stones, each stone has a positive integer weight
 *
 * Each turn, we choose the two heaviest stones and smash them together; suppose
 * the stones have weights x and y with x greater than or equal to y
 *
 * The result of this smash is: 
 *
 *  - if x == y, both stones are totally destroyed
 *  - if x != y, the stone of weight x is totally destroyed and the stone of 
 *    weight y has new weight y-x
 *
 * At the end, there is at most 1 stone left
 *
 * Return the weight of this stone ( or 0 if there are no stones left)
 *
 * @author Wali Morris 
 * @since 06/05/2020
 */

import java.util.stream.Collectors;
import java.util.*;

public class LastStone {
    public static void main(String[] args) {
        int[] input1 = {};
        int output = lastStoneWeight(input1);
        System.out.println("Last stone weight: " + output);
    }
    
    public static int lastStoneWeight(int[] stones) {
        /* Creates an ArrayList of the array stones */
        List<Integer> stonesList = Arrays.stream(stones)
                                         .boxed()
                                         .collect(Collectors.toList());
        /* empty list, return 0 */
        if ( stonesList.size() == 0 ) {
            return 0;
        }
        /* Its guarenteed the there will be 1 element, unless there are none. In this case
         * get the maximum number and in case of duplicates give x the value of the first 
         * seen max num. Remove this from the list and do the same for the next maximum and 
         * give y this value */
        while ( !(stonesList.size() == 1) ) {
            int x = Collections.max(stonesList);
            stonesList.remove(stonesList.indexOf(x));
            int y = Collections.max(stonesList);
            stonesList.remove(stonesList.indexOf(y));
            /* if x equals y, do nothing , the elements have already been deleted from the list. 
             * If x does not equal y get the absolute value of y - x */
            if ( !(x == y) ) {
                /* new value becomes the new stone and add it to the front of the list */
                int newStone = Math.abs(y - x);
                stonesList.add(0, newStone);
            } else {
                /* at any step, if the list is empty, return 0 */
                if ( stonesList.size() == 0 ) {
                    return 0;
                }
            }
        }
        /* List is not empty, return the only element */
        return stonesList.get(0);
    }
}

/**
 * Third Maximum Number 
 *
 * Given a non-empty array of integers, return the third maximum number in this array
 * If it does not exist, return the maximum number
 *
 * @author Wali Morris
 * @since 06/06/2020
 */

import java.util.*; 

public class ThirdMax { 
    public static void main(String[] args) { 
        int[] input1 = {1, 2}; 
        int[] input2 = {2, 2, 3, 1}; 
        int[] input3 = {1, 1, 2}; 
        int output1 = thirdMax(input1); 
        int output2 = thirdMax(input2); 
        int output3 = thirdMax(input3);
        System.out.println(output1); 
        System.out.println(output2);
        System.out.println(output3);
    }
    
    public static int thirdMax(int[] nums) { 
        switch ( nums.length ) { 
            case 0: 
                return 0; 
            case 1: 
                return nums[0];
            case 2:  
                /* nums array length is 2, create an arraylist and return the max */
                List<Integer> numbers = new ArrayList<>();
                for ( Integer n : nums ) {
                    numbers.add(n);
                }
                return Collections.max(numbers);
        }
        List<Integer> numbersList = new ArrayList<>();
        for ( Integer num : nums ) {
            numbersList.add(num);
        }
        /* This is the original max value in nums array before any elements are removed. 
         * If the size of nums array is 3 or greater, but after removing elements has a 
         * size of 0 then the original max element will be returned */
        final int orgMax = Collections.max(numbersList);
        int max = 0, count = 0;
        while ( count < 2) {
            /* deletes the first two max elements from the list */
            max = Collections.max(numbersList);
            numbersList.removeAll(Collections.singleton(max));
            count++;
            if ( numbersList.size() == 0 ) {
                return orgMax;
            }
        }
        /* returns the third max element from the list */
        return Collections.max(numbersList);

    }
}

/**
 * Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palidrome
 * @see ListNode.java: for definition of ListNode
 *
 * Note: I know there should be a reference to the back of the LinkedList
 * At this point I'm not sure how to implement this feature, so I'm using
 * another method I can think of which is much slower; I will continue 
 * studying LinkedList and hopefully implement a much faster solution 
 * utilizing the reference to the back of the linkedList
 *
 * @author Wali Morris 
 * @since 06/09/2020
 */

import java.util.*;

public class PalindromeLinkedList2 {
    public static void main(String[] args) {
        ListNode input0 = new ListNode(1);
        ListNode input1 = new ListNode(-129, new ListNode(-128));
        ListNode input2 = new ListNode(1, new ListNode(2,
                          new ListNode(2, new ListNode(1))));
        boolean output0 = isPalindrome(input0);
        boolean output1 = isPalindrome(input1);
        boolean output2 = isPalindrome(input2);
        System.out.println(output0);
        System.out.println(output1);
        System.out.println(output2);
    }

    /* To test if LinkedList is a palidrome, use an ArrayList to store elements 
     * of the LinkedList. Next, create two pointers, one at the front of the 
     * arrayList and one at the back. Compare elements until the pointers meet in 
     * the middle of the arrayList. */
    public static boolean isPalindrome(ListNode head) {
        // empty linkedlist and linkedlist with one element returns true
        if ( head == null || head.next == null ) {
            return true;
        }
        List<Integer> valList = new ArrayList<>();
        ListNode current = head;
        while ( !(current == null) ) {
            valList.add(current.val);
            current = current.next;
        }
        int count = 0;
        // pointers to the first and last elements in arrayList 
        int front = 0, back = valList.size() - 1;
        while ( !(count == valList.size() / 2) ) {
            if ( !(valList.get(front).equals(valList.get(back))) ) {
                return false;
            }
            count++; // increment count
            front++; // move front pointer to right 
            back--; // move back pointer to left 
        }
        return true;
    }
}

/**
 * Shuffle the Array
 *
 * Given the array nums consisting of 2n elements in the form [x1, x2,..., y1, y2...]; 
 * Return the array in the form [x1, y1, x2,y2...., xn, yn]
 *
 * @author Wali Morris 
 * @since 06/11/2020
 */

import java.util.*;

public class ShuffleArray {
    public static void main(String[] args) {
        int[] input1 = {2, 5, 1, 3, 4, 7};
        int[] input2 = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] input3 = {1, 1, 2, 2};
        int[] output1 = shuffle(input1, 3);
        int[] output2 = shuffle(input2, 4);
        int[] output3 = shuffle(input3, 2);
        System.out.println(Arrays.toString(output1));
        System.out.println(Arrays.toString(output2));
        System.out.println(Arrays.toString(output3));
    }

    public static int[] shuffle(int[] nums, int n) {
        /* A new array to store the elements of nums array */
        int[] nums2 = new int[nums.length];
        /* x points to first x element, y points to first y element */
        int ptrX = 0, ptrY = n;
        /* every iteration x and y pointer skips to next x and y elements in nums 
         * and inserts those elements in place in nums2 */
        for (int i = 0; i < nums.length-1; i+=2 ) {
            nums2[i] = nums[ptrX];
            nums2[i+1] = nums[ptrY];
            ptrX++; // go to next x index
            ptrY++; // go to next y index
        }
        return nums2;
    }
}

/**
 * Make Two Arrays Equal by Reversing Sub-Arrays
 *
 * Given two integer arrays of equal length target and arr: 
 * Return true if you can make arr equal to target, or false
 *
 * @author Wali Morris
 * @since 06/12/2020
 */

import java.util.*;

public class TwoArraysEqual {
    public static void main(String[] args) {
        int[] target1 = {1, 2, 3, 4};
        int[] arr1 = {2, 4, 1, 3};
        int[] target2 = {7};
        int[] arr2 = {7};
        int[] target3 = {1, 12};
        int[] arr3 = {12, 1};
        int[] target4 = {3, 7, 9};
        int[] arr4 = {3, 7, 11};
        int[] target5 = {1, 1, 1, 1, 1};
        int[] arr5 = {1, 1, 1, 1, 1};
        boolean output1 = canBeEqual(target1, arr1);
        boolean output2 = canBeEqual(target2, arr2);
        boolean output3 = canBeEqual(target3, arr3);
        boolean output4 = canBeEqual(target4, arr4);
        boolean output5 = canBeEqual(target5, arr5);
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
        System.out.println(output4);
        System.out.println(output5);
    }

    /* Sorts both arrays and compares for equality */
    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        if ( Arrays.equals(target, arr) ) {
            return true;
        }
        return false;
    }
}

/**
 * Running Sum of 1d Array 
 * 
 * Given an array nums: We define a running sum of an array as runningSum[i] = sum(nums[0]...nums[i])
 * Return the running sum of nums
 * 
 * @author Wali morris
 * @since 06/14/2020
 */ 

class RunningSum { 
    public int[] runningSum(int[] nums) { 
        /* iterating, beginning at num[1] and add the nums[i-1](total of elements counted
         * thus far, to nums[i] will give the running count */ 
        for ( int i = 1; i < nums.length; i++ ) { 
            nums[i] += nums[i-1]; 
        } 
        return nums; 
    } 
} 

/**
 * Reverse Integer 
 *
 * Given a 32-bit signed integer, reverse digits of an integer
 *
 * @author Wali Morris 
 * @since 06/15/2020
 */

import java.util.*;
import java.math.BigInteger;

public class ReverseInteger {
    public static void main(String[] args) {
        int output1 = reverse(120);
        int output2 = reverse(-123);
        int output3 = reverse(123);
        int output4 = reverse(7);
        int output5 = reverse(-150);
        int output6 = reverse(-6);
        int output7 = reverse(-2147483648);
        int output8 = reverse(1534236469);

        System.out.println("120 -> " + output1);
        System.out.println("-123 -> " + output2);
        System.out.println("123 -> " + output3);
        System.out.println("7 -> " + output4);
        System.out.println("-150 -> " + output5);
        System.out.println("-6 -> " + output6);
        System.out.println("-2147483648 -> " + output7);
        System.out.println("1534236469 -> " + output8);
    }
    
    public static int reverse(int x) {
        /* returns x if it's a 1 digit number(negative or positive) */
        if ( x % 10 == x ) {
            return x;
        }
        /* converts x to a string and reverses the string */
        String intXToString = Integer.toString(x);
        StringBuilder sb = new StringBuilder();
        if ( x < 0 ) { // starts by appending - if x is a negative number
            sb.append("-");
        }
        for ( int i = intXToString.length()-1; i >= 0; i-- ) {
            if ( intXToString.charAt(i) == '-' ) {
                continue; // ignores the negative at the beginning of negative numbers 
            }
            sb.append(intXToString.charAt(i));
        }
        /* Strings with 9 or less digits are parsed to their respective int values and returned */
        if ( sb.toString().length() < 10 ) {
            return Integer.valueOf( sb.toString());
        }
        /* Larger numbers(10+ digits) with 32 bit upper and lower bounds are converted to BigInteger 
         * and compared to upper and lower bounds, if BigInt is outside of these bounds return 0 */
        BigInteger maxBitsUpper = new BigInteger("2147483647"); // 32 bit upper bound
        BigInteger maxBitsLower = new BigInteger("-2147483647"); // 32 bit lower bound 
        BigInteger bigInt = new BigInteger(sb.toString());
        if ( bigInt.compareTo(maxBitsUpper) > 0 || bigInt.compareTo(maxBitsLower) < 0 ) {
            return 0;
        }
        return bigInt.intValue();
    }
}

/**
 * Valid Palindrome II 
 *
 * Given a non-empty string s, you may delete at most one character 
 * Judge whether you can make it a palindrone 
 *
 * NOTE: I thought this algorithm would be okay with time O(N), the maximum character 
 * for a string can be 50,000 characters. With small characters this solution works fine
 * but becomes slow after about 3,000 characters. Very inefficient for large strings. makes
 * perfect sense why it'd be so slow, only deleting one character a time, that extremely 
 * slow for 50,000 iterations. How can I reduce the number of iterations, maybe reduce by half
 * and still this algorithm would be slow. This is a work in progress... here's a potential
 * solutions: 
 * 
 * 1. find the character where the strings different and jump to this index to delete this one
 * character, if this character does not change the string to a palindrome then it should be 
 * impossible any other way
 *
 * @author Wali Morris
 * @since 06/16/2020
 */

public class ValidPalindromeII {
    public static void main(String[] args) {
        boolean output1 = validPalindrome("aba");
        boolean output2 = validPalindrome("abca");
        boolean output3 = validPalindrome("sbda");
        System.out.println("aba can become a palindrome: " + output1);
        System.out.println("abca can become a palindrome: " + output2);
        System.out.println("sbda can become a palindrome: " + output3);
    }
    
    public static boolean validPalindrome(String s) {
        /* First create a new string of s in reverse to compare to s */
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        /* checks if sb is palindrome of s before any removing of characters */
        if ( sb.toString().equals(s) ) {
            return true;
        }
        /* Begin by creating a new String and "ignoring" one value every iteration by removing it. 
         * sb and sb2(the created in place String without ignored value) will be compared each 
         * iteration for equality, returns true if at any point sb2 is a palidrome of sb */
        for ( int i = 0; i < s.length(); i++ ) {
            char removedChar = sb.charAt(i); // record the removed char
            sb.deleteCharAt(i); // delete the character 
            StringBuilder sb2 = new StringBuilder(sb); // create sb2 clone of sb and reverse sb2 
            sb2.reverse();
            if ( sb.toString().equals(sb2.toString()) ) {
                return true; // sb2 reversed is palindrome of sb, return true 
            }
            sb.insert(i, removedChar); // insert the removed character back into sb for next iteration 
        }
        return false; // no palidrome found, return false
    }
}

/**
 * Class LinkedIntList can be used to store a list of integers
 * Program credit: Building Java Programs 5th Edition
 *
 * Assignment1: Write a method called isSorted that returns true if the list 
 * is in sorted (nondecresing) order and returns false otherwise, an empty
 * list is considered sorted
 *
 * Assignment2: Write a method to reverse a linked list  
 *
 * Note: assignment methods are the last methods in this file 
 * 
 * @see LinkedListSorted.java and ListNodingAround.java: for test and client programs
 * These files can be found in github repository DS_Spring2020/CH16_LinkedList
 *
 * @author Wali Morris<walimmorris@gmail.com>  
 * @since 06/16/2020
 */

public class LinkedIntList {
    private ListNode front;

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }
    
    public int size() {
        int count = 0;
        ListNode current = this.front;
        while ( !(current == null) ) {
            current = current.next;
            count++;
        }
        return count;
    }
    
    public int get(int index) {
        return nodeAt(index).data;
    }
    
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
         } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
         }
    }
    
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }
    
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }
    
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
    
    public void reverseList() {
        /**
         * Uses three pointers, one to previous node, one to current node, 
         * and one to the next node(following)
         *
         * Naturally to reverse the node, each reference should be inverted to 
         * point to the previous node
         */
        ListNode previous = null;
        ListNode current = this.front;
        ListNode following = this.front;
        while ( current != null ) {
            following = following.next; // following becomes the next right, to reserve the link 
            current.next = previous; // current node now references previous node
            previous = current; // previous now moves to current node
            current = following; // current now moves to following 
        }
        /* At the end of this rotation previous will be the last node in the list 
         * therefore we should begin here */
        this.front = previous;
    }
    
    public boolean isSorted() {
        // returns true if list is empty or contains one element 
        if ( this.front == null || this.size() == 1 ) {
            return true;
        } else {
            ListNode current = front;
            /* iterates LinkedIntList until null verifying, at every node, that 
             * the next data element ahead of it is larger */
            while ( current.next != null ) {
                // current data element is larger than next
                if ( current.data > current.next.data ) {
                    return false;
                }
                // go to next node
                current = current.next;
            }
        }
        return true;
    }
}

/**
 * Find Smallest Letter Grade Than Target
 *
 * Given a list of sorted characters letters containing only lowercase letters, 
 * and given a target letter 'target', find the smallest element in the list 
 * that is larger than the given target 
 *
 * @author Wali Morris
 * @since 06/17/2020
 */

import java.util.*;

public class SmallestLetterGrade {
    public static void main(String[] args) {
        char[] input1 = {'c', 'f', 'j'};
        char[] input2 = {'c', 'f', 'j'};
        char[] input3 = {'c', 'f', 'j'};
        char[] input4 = {'c', 'f', 'j'};
        char[] input5 = {'c', 'f', 'j'};
        char[] input6 = {'c', 'f', 'j'};
        char output1 = nextGreatestLetter(input1, 'a');
        char output2 = nextGreatestLetter(input2, 'c');
        char output3 = nextGreatestLetter(input3, 'd');
        char output4 = nextGreatestLetter(input4, 'g');
        char output5 = nextGreatestLetter(input5, 'j');
        char output6 = nextGreatestLetter(input6, 'k');
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
        System.out.println(output4);
        System.out.println(output5);
        System.out.println(output6);
    }
    
    public static char nextGreatestLetter(char[] letters, char target) {
        /* using the ASCII decimal of lowercase characters (97-122) we can compare character
         * elements by iterating down the list and finding the first character element that 
         * occurs after the target character element. If no such element exists, return the 
         * first character in the list because the list wraps */
        for ( int i = 0; i < letters.length; i++ ) {
            if (letters[i] > target ) {
                return letters[i];
            }
        } 
        return letters[0];
    }
}

/**
 * Remove Duplicates from Sorted List 
 *
 * Given a sorted linked list, delete all duplicates such that each element 
 * appear only once
 * 
 * @see ListNode.java for reference to ListNode implementation 
 *
 * @author Wali Morris 
 * @since 06/17/2020
 */

import java.util.*;

public class RemoveDuplicatesLinkedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode list2 = new ListNode(1, new ListNode(1, new ListNode(2,
                                         new ListNode(3, new ListNode(3)))));
        ListNode outputList1 = deleteDuplicates(list1);
        ListNode outputList2 = deleteDuplicates(list2);
        ListNode current1 = outputList1;
        ListNode current2 = outputList2;
        while (current1 != null ) {
            System.out.print(current1.val + " ");
            current1 = current1.next;
        }
        System.out.println();
        while (current2 != null ) {
            System.out.print(current2.val + " ");
            current2 = current2.next;
        }
        System.out.println();
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while ( current.next != null ) { // stop one node before null to check next
            // if the following node is a duplicate, point reference to the node after duplicate node   
            if ( current.next.val == current.val ) {
                current.next = current.next.next;
            } else {
                // no duplicate, continue
                current = current.next;
            }
        }
        return head;
    }
}

/**
 * Given an array A of strings made only from lowercase letters, return a list of all
 * characters that show up in all strings within the list (including duplicates)
 *
 * For example, if a character occurs three times in all strings but not 4 times, you 
 * need to include that character three times in the final answer
 *
 * You may return the answer in any order
 *
 * @author Wali Morris 
 * @since 06/23/2020
 */

import java.util.*;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] input1 = {"bella", "label", "roller"};
        String[] input2 = {"cool", "lock", "cook"};
        List<String> output1 = commonChars(input1);
        List<String> output2 = commonChars(input2);
        System.out.println(output1);
        System.out.println(output2);
    }

    /* A helper function to assist with populating HashMaps */
    public static void populateMap(String word, Map<String, Integer> map) {
        for ( int i = 0; i < word.length(); i++ ) {
            char current = word.charAt(i);
            if ( map.containsKey(Character.toString(current)) ) {
                int count = map.get(Character.toString(current)) + 1;
                map.put(Character.toString(current), count);
            } else {
                map.put(Character.toString(current), 1);
            }
        }
    }
    
    public static List<String> commonChars(String[] A) {
        Map<String, Integer> mapToCompare = new HashMap<>();
        List<String> list = new ArrayList<>();
        /* Iterate the array of words */
        for ( int i = 0; i < A.length; i++ ) {
            String word = A[i];

            /* For the first word, populate the letters and their count to mapToCompare. Every other word will 
             * be examined based on the first word and its characters. If characters in the first world do not
             * exist in all other words, these character values in the map will be put to 0 so as not to be 
             * counted in the final push to populate the list */
            if ( i == 0 ) {
                populateMap(word, mapToCompare);
                continue;
            }

            /* In all other cases that are not the first word create a temp map and populate this temp map with the 
             * current words characters and count */
            Map<String, Integer> tempMap = new HashMap<>();
            populateMap(word, tempMap);

            /* Compare compareToMap and tempMap. If any letter(key) in tempMap is also in mapToCompare but has a lower 
             * value the value of this letter(key) in mapToCompare will be changed so it reflects the lower value of 
             * the two. If a key in mapToCompare is not also in tempMap, this key's value will be put as 0. */
            for ( String key : mapToCompare.keySet() ) {
                if ( tempMap.containsKey(key) && mapToCompare.get(key) > tempMap.get(key) ) {
                    mapToCompare.put(key, tempMap.get(key));
                } else {
                    if ( !(tempMap.containsKey(key)) ) {
                        mapToCompare.put(key, 0);
                    }
                }
            }
        }
        
        /* For every key in mapToCompare, if the key's value is 0 then the key will not be populated to the list. In the 
         * opposite case, we will add this key to list for the number of times as it's value. Example: if a keys value is
         * 2, then the key will be added to the list 2 times. */
        for ( String key: mapToCompare.keySet() ) {
            if ( mapToCompare.get(key) != 0 ) {
                int value = 0;
                int count = mapToCompare.get(key);
                while ( value < count ) {
                    list.add(key);
                    value++;
                }
            }
        }
        return list;
    }
}

/**
 * Day of the Week 
 *
 * Given a date, return the correspnding day of the week for that date
 *
 * The input given is three integers representing the day, month, and year 
 * respectively
 *
 * @author Wali Morris
 * @since 06/25/2020
 */

import java.util.*;
import java.time.*;

public class DayOfTheWeek {
    public static void main(String[] args) {
        int day1 = 31, month1 = 8, year1 = 2019;
        int day2 = 18, month2 = 7, year2 = 1999;
        int day3 = 15, month3 = 8, year3 = 1993;
        String output1 = dayOfTheWeek(day1, month1, year1);
        String output2 = dayOfTheWeek(day2, month2, year2);
        String output3 = dayOfTheWeek(day3, month3, year3);
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
    }
    
    /* Using the java.time api to parse the day of the week based on the day, month and year. If a day is 1 - 9 and 
     * '0' must precede the day and the same applies to months. There are 3 case. 
     */
    public static String dayOfTheWeek(int day, int month, int year) {
        StringBuilder dayStr = new StringBuilder();
        /* case 1: day is less than 9 and expects a 0 to precede the day, month is greater than 9 */
        if ( day < 10 && month > 9 ) {
            dayStr.append(year + "-" + month + "-" + "0" + day);
        /* case 2: day is greater than 9, but month is less than 10 and expects a 0 to precede the month */
        } else if ( day > 9 && month < 10 ) {
            dayStr.append(year + "-" + "0" + month + "-" + day);
        /* both day and month are less than 10 and expect a 0 to precede it */
        } else if ( day < 10 && month < 10 ) {
            dayStr.append(year + "-" + "0" + month + "-" + "0" + day);
        } else {
            dayStr.append(year + "-" + month + "-" + day);
        }
        DayOfWeek date = LocalDate.parse(dayStr.toString()).getDayOfWeek();
        return date.toString().substring(0, 1).toUpperCase() + date.toString().substring(1).toLowerCase();
    }
}

/**
 * Maximum Score 
 *
 * Given a string s of zeros and ones, return the maximum score after splitting the string 
 * into two non-empty substrings(left substring and right substring)
 *
 * The score after splitting a string is the number of zeros in the left substring plus the
 * number of ones in the right substring
 *
 * @author Wali Morris
 * @since 06/26/2020
 */

import java.util.*;

public class MaximumScore {
    public static void main(String[] args) {
        String input1 = "011101";
        String input2 = "1111";
        String input3 = "00111";
        int output1 = maxScore(input1);
        int output2 = maxScore(input2);
        int output3 = maxScore(input3);
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
    }
    
    /* This method returns the maximum sum of the count of leftsubstring characters that equal '0' 
     * and count of rightsubstring that equals 1. Two pointers are created, a left and right pointer.
     * Left substring will always begin at 0 and end at right pointer. Right pointer will always 
     * increment from 1+ to length of string s. These are the substrings. The occurrances of 0 and the
     * occurrances of 1 are then summed from both substrings and this sum is added to the array list. 
     */
    public static int maxScore(String s) {                                 
        /* holds all sums of left and right substring */
        List<Integer> list = new ArrayList<>();
        int left = 0, right = 1;
        while ( right < s.length() ) {
            String leftSub = s.substring(left, right);
            int leftSum = 0;
            // count '0' occurrances in left substring
            for ( int i = 0; i < leftSub.length(); i++ ) {
                if ( leftSub.charAt(i) == '0' ) {
                    leftSum++;
                }
            }
            String rightSub = s.substring(right, s.length());
            int rightSum = 0;
            // count '1' occurrances in right substring 
            for ( int j = 0; j < rightSub.length(); j++ ) {
                if ( rightSub.charAt(j) == '1' ) {
                    rightSum++;
                }
            }
            /* tally the sum of leftsub and right sub, add this sum to arraylist and  increment right and 
             * right pointer */
            int sum = leftSum + rightSum;
            list.add(sum);
            right++;
        }
        // returns the maximum sum in arraylist 
        return Collections.max(list);
    }
}

/**
 * Find Difference 
 *
 * Given two strings 's' and 't' which consist of only lowercase letters 
 *
 * String t is generated by random shuffling string s and then add one 
 * more letter at a random position 
 *
 * Find the letter that was added in 't'
 *
 * @author Wali Morris
 * @since 06/27/2020
 */

import java.util.*;

public class FindDifference {
    public static void main(String[] args) {
        String s = "a";                                                                                                                                                                                          
        String t = "aa";
        char output = findTheDifference(s, t);
        System.out.println(output);
    }

    public static char findTheDifference(String s, String t) {
        /* create a hashmap of both strings s and t in order to compare */
        Map<Character, Integer> sMap = populateMap(s);
        Map<Character, Integer> tMap = populateMap(t);
        /* iterate strings and test if character is not in the other or if an individual character 
         * count in t is greater than that characters count in s */
        for ( Character character : tMap.keySet() ) {
            if ( !(sMap.containsKey(character)) ) {
                return character;
            } else {
                /* characters exist in both maps, yet tMap has a greater count, return this character */
                if ( tMap.get(character) > sMap.get(character) ) {
                    return character;
                } 
            } 
        } 
        return '/'; // no difference in strings
    } 
    
    /* A help function to populate maps containing characters from String s and their counts */
    public static Map<Character, Integer> populateMap(String s) { 
        Map<Character, Integer> populatedMap = new HashMap<>(); 
        for ( int i = 0; i < s.length(); i++ ) { 
            if ( populatedMap.containsKey(s.charAt(i)) ) { 
                int count = populatedMap.get(s.charAt(i)) + 1; 
                populatedMap.put(s.charAt(i), count); 
            } else { 
                populatedMap.put(s.charAt(i), 1); 
            } 
        } 
        return populatedMap; 
    } 
}

/**
 * Path Crossing
 *
 * Given a string path, where path[i] = N,S,E, or W, each representing moving one unit 
 * north, south, east, or west, respectively
 *
 * You start at the origin (0,0) on a 2D plane and walk on the path specified by path 
 *
 * Return True if the path crosses itself at any point, that is, if at any time you are
 * on a location you've previously visited
 *
 * Return False otherwise 
 *
 * @author Wali Morris
 * @since 06/27/2020
 */

import java.util.*;

public class PathCrossing {
    public static void main(String[] args) {
        String input1 = "NES";
        String input2 = "NESWW";
        boolean output1 = isPathCrossing(input1);
        boolean output2 = isPathCrossing(input2);
        System.out.println(output1);
        System.out.println(output2);
    }
    
    public static boolean isPathCrossing(String path) {
        /* Initializes x and y intercepts to (0,0) and adds this first coords
         * to the mainList as the origin */
        int x = 0;
        int y = 0;
        List<List<Integer>> mainList = new ArrayList<>();
        List<Integer> origin = new ArrayList<>();
        origin.add(x);
        origin.add(y);
        mainList.add(origin);
        /* loops over the string path which in turn changes the coordinates of 
         * the origin */
        for ( int i = 0; i < path.length(); i++ ) {
            if ( path.charAt(i) == 'N' ) {
                /* path is north increment y vertical plane by 1 */
                y++;
            } else if ( path.charAt(i) == 'S' ) {
                /* path is south decrement y vertical  plane by 1 */
                y--;
            } else if ( path.charAt(i) == 'E' ) {
                /* path is east increment horizontal plane(right) by 1 */
                x++;
            } else {
                /* path is west decrement horizontal plane(left) by 1 */
                x--;
            }
            /* the subList consists of the (x,y) coordinates after running the 
             * path. for each sublist x is in index 0 and y is in index 1 */
            List<Integer> subList = new ArrayList<>();
            subList.add(x);
            subList.add(y);
            /* if the mainList contains a nested list such as subList, return 
             * true */
            if ( mainList.contains(subList) ) {
                return true;
            /* else add the sublist to the mainlist */
            } else {
                mainList.add(subList);
            }
        }
        /* The path never returns to origin or repeats the same path */
        return false;
    }
}

/**
 * String Matching in an Array
 *
 * Given an array of string words, return all strings in words which is substring
 * of another word in any order 
 *
 * String words[i] is substring of words[j], if can be obtained removing some characters
 * to the left and/or right side of words[j]
 *
 * @author Wali Morris
 * @since 06/28/2020
 */

import java.util.*;

public class StringMatching {
    public static void main(String[] args) {
        String[] words1 = {"mass", "as", "hero", "superhero"};
        String[] words2 = {"leetcode", "et", "code"};
        String[] words3 = {"blue", "green", "bu"};
        List<String> output1 = stringMatching(words1);
        List<String> output2 = stringMatching(words2);
        List<String> output3 = stringMatching(words3);
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
    }
    
    public static List<String> stringMatching(String[] words) {
        List<String> wordsList = new ArrayList<>();
        if ( words.length == 1 ) {
            return wordsList;
        }
        /* Iterates array of words and initializes a variable of the current word. iterates array 
         * words and checks if current word is a substring of any other word in the array. If the 
         * current word is not the word being compared against it, if the second word contains a 
         * substring of the current word, and wordsList does not already contain the current word 
         * then current word is added to the array list.*/
        for ( int i = 0; i < words.length; i++ ) {
            String word = words[i];
            for ( int j = 0; j < words.length; j++ ) {
                String word2 = words[j];
                if ( !word.equals(word2) && word2.contains(word) &&
                                        !wordsList.contains(word)) {
                    wordsList.add(word);
                    break;
                }
            }
        }
        return wordsList;
    }
}

/**
 * Sum of Two Integers
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and - 
 *
 * @author Wali Morris 
 * @since 07/02/2020
 */

import java.util.*;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int a1 = 1, b1 = 2;
        int a2 = -2, b2 = 3;
        int output1 = getSum(a1, b1);
        int output2 = getSum(a2, b2);
        System.out.println(output1);
        System.out.println(output2);
    }

    public static int getSum(int a, int b) {
        /* both a and b are 0 so return 0 */
        if ( a == 0 && b == 0 ) {
            return 0;
        /* a is 0, so return b */
        } else if ( a == 0 && b != 0 ) {
            return b;
        /* b is 0, so return a */
        } else if ( a != 0 && b == 0 ) {
            return a;
        /* integer b is less than zero: in this case take away 1 from integer a every loop up until 
         * start equals integer b */
        } else if ( b < 0 ) {
            int start = 0;
            while ( start != b ) {
                a--;
                start--;
            }
        /* integer b is greater than zero: in this case add 1 to integer a every loop up until 
         * start equals integer b */
        } else {
            int start = 0;
            while ( start != b ) {
                a++;
                start++;
            }
        }
        return a;
    }
}

/**
 * First Unique Character in a String 
 *
 * Given a string, find the first non-repeating character in it and return its index; if 
 * it doesn't exist, return -1
 *
 * @author Wali Morris
 * @since 07/02/2020
 */

import java.util.*;

public class FirstUnique {
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        int output1 = firstUniqueChar(s1);
        int output2 = firstUniqueChar(s2);
        System.out.println(output1);
        System.out.println(output2);
    }
    
    public static int firstUniqueChar(String s) {
        /* return -1 for empty string */
        if ( s.length() == 0 ) {
            return -1;
        } else if ( s.length() == 1 ) {
        /* return index 0 for string of length 1, that char is unique */
            return 0;
        } else {
            /* create a set to push characters from the string, if a character is already in the set this character 
             * won't be added so this allows for the deletion of the character which would've been a duplicate in 
             * the set. This character will be added to the banned characters list so if this character is seen again, 
             * it has no chance of being added to the set again */
            Set<Character> set = new HashSet<>();       
            List<Character> banned = new ArrayList<>();         
            for ( int i = 0; i < s.length(); i++ ) {
                if ( set.contains(s.charAt(i)) ) { // set contains this character?
                    set.remove(s.charAt(i)); // delete it from the set  
                    banned.add(s.charAt(i)); // add it to the banned list
                } else {
                    if ( !banned.contains(s.charAt(i)) ) { // banned list does not contain this character
                        set.add(s.charAt(i)); // add it to the set
                    }
                }
            }           
            /* iterates original string and examines the set which should now contain only unique characters. 
             * The first character in the original string that is present in the unique set will be returned.
             */
            for (int j = 0; j < s.length(); j++ ) {
                if ( set.contains(s.charAt(j)) ) {
                    return j;   
                }
            }
        }
        /* no such unique characters */
        return -1;
    }
}   

/**
 * Best Time to Buy and Sell Stock 
 *
 * Say you have an array for which the ith element is the price of a given 
 * stock on day i
 *
 * If you were only permitted to complete at most on transaction (by one and 
 * sell one share of the stock), design an algorithm to find the maximum profit
 *
 * NOTE: You cannot sell a stock before you buy one
 *
 * @author Wali Morris 
 * @since 07/03/2020
 */

import java.util.*;

public class MaxProfit {
    public static void main(String[] args) {
        int[] input1 = {7, 1, 5, 3, 6, 4};
        int[] input2 = {7, 6, 4, 3, 1};
        int[] input3 = {4, 7, 2, 1};
        int[] input4 = {3, 2, 6, 0, 3};
        int output1 = maxProfit(input1);
        int output2 = maxProfit(input2);
        int output3 = maxProfit(input3);
        int output4 = maxProfit(input4);
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
        System.out.println(output4);
    }
    
    public static int maxProfit(int[] prices) {
        if ( prices.length == 0 || prices.length == 1 ) {
            return 0;
        }
        /* within the prices array, each price falls on a day represented by it's index. 
         * A map is created to record the lowest price and its day, as well as the max 
         * price and it's day. The profits list holds all profits made that contains a 
         * day with min price and a day with max price that falls after the min price 
         * day */
        Map<String, Integer> minMaxPriceAndDay = new HashMap<>();
        ArrayList<Integer> profits = new ArrayList<>();
        minMaxPriceAndDay.put("min", 0); // starts min day and price at day 1 
        minMaxPriceAndDay.put("max", 0); // starts max day and price at day 1
        for ( int i = 1; i < prices.length; i++ ) {
            int price = prices[i];
            int day = i;
            /* if a price is found to be less than the current minimum and this price is not last 
             * the last day, minimum price becomes this day and max price becomes this day */
            if ( prices[i] < prices[minMaxPriceAndDay.get("min")] && !(i == prices.length -1) ) {
                minMaxPriceAndDay.put("min", day);
                minMaxPriceAndDay.put("max", day);
            }
            /* if this price falls on a day greater than the min price day and the price is greater than 
             * the current maximum price, this day becomes the day of the max price after min price day */
            if ( day > minMaxPriceAndDay.get("min") && prices[i] > prices[minMaxPriceAndDay.get("max")] ) {
                minMaxPriceAndDay.put("max", day);
            }
            /* if the max price day is not 0(no max price has been found) and max price day does not fall 
             * on the same day as min price( we've found a min price and max price and the list and the trading 
             * days is not yet over) calculate the profts from min price and max price and add it to profits 
             * list */
            if ( minMaxPriceAndDay.get("max") != 0 && minMaxPriceAndDay.get("max") != minMaxPriceAndDay.get("min") ) {
                profits.add(prices[minMaxPriceAndDay.get("max")] - prices[minMaxPriceAndDay.get("min")]);
            }
        }
        /* there have been no profits, return 0 */
        if ( profits.isEmpty() ) {
            return 0;
        }
        /* returns the maximum profit made */
        return Collections.max(profits);
    }
}

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * For multiples of three it should output "Fizz" instead of the number and for the
 * multiples of five output "Buzz". For numbers which are multiples of both three and
 * five output "FizzBuzz".
 *
 * @author Wali Morris
 * @since 07/25/2020
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int input1 = 15;
        int input2 = 25;
        List<String> output1 = fizzBuzz(input1);
        List<String> output2 = fizzBuzz(input2);
        System.out.println(output1);
        System.out.println(output2);
    }

    /**
     * @param n : the last number in the sequence from 1 - n
     * @return : An arrayList of type string which returns "Fizz" if x is a multiple of 3, "Buzz" 
     * if x is a multiple of 5, "FizzBuzz" if x is a multiple of both 3 and 5. Returns the string 
     * representation of x if the number is not a multiple of 3 or 5.
     */
    public static List<String> fizzBuzz(int n) {
        int x = 1; // sequence begins at one
        List<String> numbers = new ArrayList<>();
        while ( x < n + 1 ) {
            if (x % 3 == 0 && !(x % 5 == 0) ) {
                numbers.add("Fizz");    
            } else if (x % 5 == 0 && !(x % 3 == 0) ) {
                numbers.add("Buzz");    
            } else if (x % 5 == 0 && x % 3 == 0) {
                numbers.add("FizzBuzz");    
            } else {
                numbers.add(Integer.toString(x));
            }
            x++;
        }
        return numbers;
    }
}

/**
 * Average Salary Excluding the Minimum and Maximum Salary
 *
 * Given an array of unique integers, salary, where salary[i] is the salary of the employee i.
 * Return the average salary of employees excluding the minimum and maximum salary.
 * 
 * @author Wali Morris 
 * @since 07/26/2020
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] salary1 = {4000, 3000, 1000, 2000};
        int[] salary2 = {1000, 2000, 3000};
        int[] salary3 = {6000, 5000, 4000, 3000, 2000, 1000};
        int[] salary4 = {8000, 9000, 2000, 3000, 6000, 1000};
        double output1 = average(salary1);
        double output2 = average(salary2);
        double output3 = average(salary3);
        double output4 = average(salary4);
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
        System.out.println(output4);
    }

    /**
     * @param salary : The salaries of all employees
     * @return : average of all salaries without max salary and min salary 
     */
    public static double average(int[] salary) {
        
        /* initializes min and max salary to the first salary in the list. Then iterates all salaries and
         * compares; takes new max salary and new min salary from current, if that is the case. Every salary
         * is added to the total. The final calculation returns a double of the total salary amount minus
         * the max and min salary divided by the number of salaries - 2.
         */
        int maxSalary = salary[0];
        int minSalary = salary[0];
        int total = 0;
        for ( int i = 0; i < salary.length; i++ ) {
            maxSalary = Math.max(salary[i], maxSalary);
            minSalary = Math.min(salary[i], minSalary);
            total += salary[i];
        }
        return (double) (total - maxSalary - minSalary) / (salary.length - 2);

    }
}

/**
 * Design HashMap
 * @see MyHashMap.java below this main method. 
 *
 * Design a HashMap without using any built-in hash table libraries
 *
 * To be specific, your design should include these functions:
 *
 * put(key, value) : insert a (key, value) pair into the HashMap. If the value already exists in the HashMap,
 * update the value.
 *
 * get(key) : Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
 * for the key.
 *
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * @author Wali Morris
 * @since 07/26/2020
 */

public class Main {

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2, 1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }
}

/**
 * MyHashMap class that implements a HashMap data structure utilizing the ArrayList data structure as the underlying
 * structure. Within the ArrayList is a nested list containing key/value pair.
 *
 * @author Wali Morris
 * @since 07/27/2020
 */

import java.util.*;

public class MyHashMap {
    private List<List<Integer>> mainList;

    /**
     * MyHashMap uses a ArrayList data structure in the underlying HashMap structure. Initializes a nested ArrayList
     * structure that nest a key and value pair as a single list.
     */
    public MyHashMap() {
        this.mainList = new ArrayList<>();
    }

    /**
     * @param key : integer to put into MyHashMap as key
     * @param value : integer to put into MyHashMap as the key's value
     */
    public void put(int key, int value) {
        /* If the outer list is empty, there's no need to check for nested key/value list pairs. Instead this method
         * will insert a list containing key/value pair. If the list does contain inner key/value pairs then it's
         * checked to ensure the key(index 0 of inner list) does not exist. If this key already exists, then it will
         * be changed, if it does not exist then that key/value pair will be mapped.
         */
        if ( this.mainList.size() > 0 ) {
            for ( int i = 0; i < this.mainList.size(); i++ ) {
                List<Integer> current = this.mainList.get(i);
                int mapKey = current.get(0);
                if ( mapKey == key ) {
                    this.mainList.remove(current);
                }
            }
        }
        /* Creates a new key/value pair mapping as a inner list of the outer main list. key is at index 0 and value
         * is at index 1 of the inner list.
         */
        List<Integer> keyValue = new ArrayList<>();
        keyValue.add(key);
        keyValue.add(value);
        this.mainList.add(keyValue);
    }

    /**
     * @param key : the key to search for within the MyHashMap data structure
     * @return : the value pertaining to the key, returns -1 if there is no such key
     */
    public int get(int key) {
        int value = -1;
        if ( this.mainList.size() > 0 ) {
            for (int i = 0; i < this.mainList.size(); i++ ) {
                List<Integer> current = this.mainList.get(i);
                int mapKey = current.get(0);
                if ( mapKey == key ) {
                    value = (int) current.get(1);
                }
            }
        }
        return value;
    }

    /**
     * @param key : removes key/value pair from MyhashMap data structure
     */
    public void remove(int key) {
        /* First ensures that the outer(mainList) is not empty. If empty, does nothing. If the mainlist is not empty
         * and contains key/value mappings, then iterate through each inner list(key/value mappings) and check the
         * index 0 of each inner list, if key is found then deletes that list(key/value map).
         */
        if ( this.mainList.size() > 0 ) {
            for ( int i = 0; i < this.mainList.size(); i++ ) {
                List<Integer> current = this.mainList.get(i);
                int mapKey = current.get(0);
                if ( mapKey == key ) {
                    this.mainList.remove(current);
                }
            }
        }
    }
}

package com.morris.TwentyFive;

import java.util.HashMap;
import java.util.Map;

/**
 * Element Appearing More Than 25% in Sorted Array
 *
 * Given an integer array sorted in non-decreasing order, there is exactly one integer in the array
 * that occurs more than 25% of the time. Return that integer.
 *
 * @author Wali Morris
 * @since 07/30/2020
 */
public class Main {

    public static void main(String[] args) {
        int[] input = {1, 2, 2, 6, 6, 6, 7, 10};
        int output = findSpecialInteger(input);
        System.out.println(output);
    }

    public static int findSpecialInteger(int[] arr) {
        // returns the only integer in array for array of size 1
        if ( arr.length == 1 ) {
            return arr[0];
        }
        /* Maps integer in list to number of times it's been seen. If a integer appears more than 25% 
         * of times in the array, returns that integer */ 
        Map<Integer, Integer> nums = new HashMap<>();
        for (int num : arr) {
            /* if num has been seen, add number and number of times it has been seen to the map */ 
            if (nums.containsKey(num)) {
                nums.put(num, nums.get(num) + 1);
                /* appears more than 25%? return this integer */ 
                if ( (float) nums.get(num) / arr.length * 100 > 25.0 ) {
                    return num;
                }
            } else {
                /* has not been seen, add number and 1 (integer has only been seen once) */ 
                nums.put(num, 1);
            }

        }
        return -1;
    }
}

package com.morris.LeetcodeChallenge;

import java.util.Iterator;

/**
 * Consecutive Characters
 *
 * Given a String s, the power of the String is the maximum length of a non-empty substring that contains
 * only one unique character. Return the power of the String.
 *
 * @author Wali Morris
 * @since 07/30/2020
 */

public class Main {
    public static void main(String[] args) {
        int output1 = maxPower("leetcode");
        int output2 = maxPower("abbcccddddeeeeedcba");
        int output3 = maxPower("triplepillooooow");
        int output4 = maxPower("hooraaaaaaaaaaay");
        int output5 = maxPower("tourist");
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
        System.out.println(output4);
        System.out.println(output5);
    }

    /* maxConsecutive variable tracks the maximum count of consecutive numbers seen, while the count variable is 
     * dynamic and changes as different consecutive characters are seen; variable count tracks consecutive characters. 
     * variable count begins at 1, and a loop begins to track each character. If characters are consecutive count is
     * incremented until the character is no longer the same. Once a different character is seen, the current count 
     * is than checked against the maximum consecutive characters seen. If count is larger, then max consecutive 
     * becomes count. 
     */
    public static int maxPower(String s) {
        int maxConsecutive = 1, count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) == s.charAt(i)) {
                count++;
                maxConsecutive = count > maxConsecutive ? count : maxConsecutive;
            } else {
                count = 1;
            }
        }
        return maxConsecutive;
    }
}

package com.morris.LeetcodeChallenge;

/**
 * Max Consecutive Ones
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * @author Wali Morris
 * @since 07/30/2020
 */

public class Main {
    public static void main(String[] args) {
	    int[] input = {1, 1, 0, 1, 1, 1};
	    int output = findMaxConsecutiveOnes(input);
	    System.out.println(output);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsec = 0, count = 0;
        for ( int i = 0; i < nums.length; i++ ) {
            if (nums[i] == 1) {
                count++;
                maxConsec = Math.max(count, maxConsec);
            } else {
                count = 0;
            }
        }
        return maxConsec;
    }
}

package com.morris.augustchallenge;

/**
 * Given a word, you need to judge whether the usage in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * 1. All letters in this word are capital, like "USA"
 * 2. All letters in this word are not capitals, like "leetcode"
 * 3. Only the first letter in this word is capital, like "Google"
 *
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * August 2020 Leetcode Challenge 
 * @author Wali Morris
 * @since 08/01/2020
 */
public class Main {
    public static void main(String[] args) {
        String A = "USA";
        String B = "FlaG";
        String C = "Google";
        String D = "FlaberGasted";
        String E = "Onepac";
        boolean outputA = detectCapitalUse(A);
        boolean outputB = detectCapitalUse(B);
        boolean outputC = detectCapitalUse(C);
        boolean outputD = detectCapitalUse(D);
        boolean outputE = detectCapitalUse(E);
        System.out.println(outputA);
        System.out.println(outputB);
        System.out.println(outputC);
        System.out.println(outputD);
        System.out.println(outputE);
    }

    public static boolean detectCapitalUse(String word) {
        /* Takes word and capitalizes the first letter and makes all other letters lowercase */
        String firstLetterCapitalOnly = word.substring(0, 1) + word.substring(1).toLowerCase();
        
        /* Case 1: checks if word is all uppercase
         * Case 2: checks if word is all lowercase
         * Case 3: checks if word contains on first letter that's capitalized
         * if none of these conditions are meet, method returns false
         */
        if (word.toUpperCase().equals(word) || word.toLowerCase().equals(word) ||
                firstLetterCapitalOnly.equals(word) ) {
            return true;
        } else {
            return false;
        }
    }
}

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
     * MyHashSet begins as an array set to accept a maximum of ten elements. The variable size monitors the 
     * number of elements within the set. Ofcourse, once MyHashSet is instantiated, we begin with zero elements. 
     */
    public MyHashSet() {
        this.set = new int[10];
        this.size = 0;
    }

    /**
     * To add an element the user must provided the key to be added. Arrays are set on initiation so before added
     * any element to the set, we ensure there is space enough for this set. If there is no space, the array is 
     * expanded by ten more available spaces. The set is then examined to ensure the key is not already within the
     * set; if the key is present adding to the set is ignored. If the key is not present, it is added. 
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
     * Increases the set by plus ten available spaces. 
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

package com.morris.augustchallenge;

/**
 * Design HashSet
 *
 * Design a HashSet without using any built-in hash table libraries.
 * To be specific, your design should include these functions:
 * A. add(value) : insert a value into the HashSet.
 * B. contains(value) : Return whether the value exists in the hashSet or not.
 * C. remove(value) : Remove a value in the HashSet. If teh value does not exist
 * int the HashSet, do nothing.
 */

public class Main {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        System.out.println(set.contains(1));
        System.out.println(set.toString());
        set.add(1);
        System.out.println(set.contains(1));
        System.out.println(set.toString());
        set.remove(1);
        System.out.println(set.toString());
        System.out.println(set.contains(1));
        System.out.println("\n/// below is leetcode's test ///");
        set.add(1);
        set.add(2);
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        System.out.println(set.toString());
        System.out.println(set.getSize());
        set.add(2);
        System.out.println(set.contains(2));
        System.out.println(set.getSize());
        System.out.println(set.toString());
        set.remove(2);
        System.out.println(set.contains(2));
        System.out.println(set.getSize());
        System.out.println(set.toString());

        /* currently the MyHashSet data structure is working as planned with small numbers.
         * My first implementation initialized an array as the base structure at size 10.
         * I think if I tried to add more than 10 elements in MyHashSet structure the compiler
         * will through an index out of bounds error so let's try it out.
         *  */
        System.out.println("\n/// Start of new tests ///");
        MyHashSet set2 = new MyHashSet();
        set2.add(11);
        set2.add(12);
        set2.add(5);
        set2.add(17);
        set2.add(23);
        set2.add(106);
        set2.add(233);
        set2.add(1);
        set2.add(99);
        set2.add(33);
        System.out.println(set2.getSize());
        System.out.println(set2.toString());
        // adding a duplicate just to check
        set2.add(17);
        System.out.println(set2.getSize()); // same size, duplicate wasn't added
        System.out.println(set2.toString()); // prints same map
        // remove element in middle of set
        set2.remove(23);
        // there was an out of bounds error, corrected by stopping loop before last element
        // after correction, the remove method worked properly
        System.out.println(set2.getSize());
        System.out.println(set2.toString());

        // now let's test our structure by adding more than 10 elements
        set2.add(44);
        set2.add(55);
        set2.add(89);
        set2.add(101);

        /* as predicted, we received index out of bounds exception when adding these 4 new elements.
         * Fix: In order to fix this, I've added a private method in the MyHashSet class called
         * increaseSet(). When the set reaches the capacity of 10 elements, the set is then increased
         * by 1 for every new element added. This allows the set to be a bit more dynamic and flexible
         * as clients want to increase and decrease the size of the set. Here are some questions: once
         * the array reaches capacity, should I increase it by more than 1? Let's say 10? The problems
         * I see with this is there may be more memory used. The good thing I see is there will be less
         * computation if a client wants to add many more elements. NOTE: I changed it to increase by 10
         * once capacity is reached because I think it'll cause less resources on the backend by only
         * incrementing one every time(under the hood we are creating a new temp array and adding all
         * elements from the original into the temp, this is expensive). Let's see what our set looks like
         * now.
         */

        System.out.println(set2.getSize());
        System.out.println(set2.toString());

        // let's add multiple duplicate elements to test that our set will not change
        set.add(101);
        set.add(1);
        set.add(17);
        set.add(12);
        set.add(106);
        System.out.println(set2.getSize());
        System.out.println(set2.toString());
        // great, no new elements were added and the properties(size) remained the same
        // let's submit this to leetcode
    }
}

package com.morris.augustchallenge;

import java.util.ArrayList;
import java.util.List;

/**
 *  Valid Palindrome
 *
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring
 *  cases. For the purpose of this problem, we define empty strings as valid palindrome.
 *
 * @author Wali Morris
 * @since 08/03/2020
 * August Leetcode Challenge
 */

public class Main {

    public static void main(String[] args) {
        String A = "A man, a plan, a canal: Panama";
        String B = "race a car";
        String C = "0P";
        boolean outputA = isPalindrome(A);
        boolean outputB = isPalindrome(B);
        boolean outputC = isPalindrome(C);
        System.out.println(outputA);
        System.out.println(outputB);
        System.out.println(outputC);
    }

    /**
     * After ensuring String s is not empty and contains more than one character, convert s to lowercase.
     * Two Lists are created, one list will contain all alphanumeric characters from the original order of
     * s and the other List will contain all alphanumeric characters from the reverse order of original s.
     * These list are then compared for equality.
     * @param s : The examined String
     * @return : If Lists contain alphanumeric characters in the same order return true, else returns false.
     */
    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        String s2 = s.toLowerCase();
        List<Character> forward = new ArrayList<>(), backward = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char charFromForward = s2.charAt(i), charFromBackward = s2.charAt(s2.length() - i - 1);
            boolean isValidForward = Character.isLetterOrDigit(charFromForward);
            boolean isValidBackward = Character.isLetterOrDigit(charFromBackward);
            if ( isValidForward )
                forward.add(charFromForward);
            if ( isValidBackward )
                backward.add(charFromBackward);
        }
        return forward.equals(backward);
    }
}

package com.morris.augustchallenge;

import java.util.*;

/**
 * Find all Duplicates in an Array
 *
 * Given an array of integers 1 <= a[i] <= n (n = size of array), some elements appear twice and others
 * appear once. Find all elements that appear twice in this array. 
 * 
 * @author Wali Morris
 * @since 08/06/2020
 */

public class Main {
    public static void main(String[] args) {
        int[] A = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> outputA = findDuplicates(A);
        System.out.println(outputA);
    }

    /**
     * Notes: adding the size of both the arraylist and hashset as nums.length decreased time complexity by 10%.
     * I think this is because although both collections are dynamic, they do have a capacity and once that
     * capacity is reached, more space must be added to the each. This implementation also increased memory
     * usage.
     *
     * Algorithm: Algorithm is not so great, for one it needs to iterate every element in Array(nums) so time
     * complexity is O(n) and large arrays would just take too much time. How are some ways I can lower the
     * cost? During each iteration, the size of the set is recorded and n is added to the set. If the set
     * remains the same size that means n was a duplicate and therefore n is added to the List that'll be
     * returned.
     * @param nums : Array of numbers
     * @return : duplicates of the Array
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> numsList = new ArrayList<>(nums.length);
        Set<Integer> bigSet = new HashSet<>(nums.length);
        for (int n : nums) {
            int bigSetOriginalSize = bigSet.size();
            bigSet.add(n);
            if ( bigSet.size() == bigSetOriginalSize ) {
                numsList.add(n);
            }
        }
        return numsList;
    }
}

package com.morris.augustchallenge;

/**
 * Student Attendance Record I
 *
 * You are given a string representing an attendance record for a student. The record only contains
 * the following three characters:
 * 'A': Absent
 * 'L': Late
 * 'P': Present
 *
 * A student could be awarded if his/her attendance record doesn't contain more than one 'A' or more
 * than two continuous 'L'.
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * @author Wali Morris
 * @since 08/12/2020
 */

public class Main {
    public static void main(String[] args) {
        String A = "PPALLP";
        String B = "PPALLL";
        boolean outputA = checkRecord(A);
        boolean outputB = checkRecord(B);
        System.out.println(outputA);
        System.out.println(outputB);
    }

    public static boolean checkRecord(String s) {
        int absentCount = 0;
        int consecutiveLate = 0;
        for ( int i = 0; i < s.length(); i++ ) {
            /* Character is 'A' therefore being late is not consecutive so consecutive lates can 
             * be reset to 0, but 'A': absent counts should be incremented. If more than one absent
             * count, return false because student does not warrant a reward. 
             */
            if (s.charAt(i) == 'A') {
                absentCount++;
                consecutiveLate = 0;
                if (absentCount > 1) {
                    return false;
                }
                /* If character is 'L' increment count, if late count has not been reset and more than 
                 * two consecutive late counts have been counted, return false: student does not warrant 
                 * any rewards. 
                 */
            } else if ( s.charAt(i) == 'L' ) {
                consecutiveLate++;
                if (consecutiveLate > 2) {
                    return false;
                }
                /* Student was present, reset consecutive late count and continue. */ 
            } else {
                consecutiveLate = 0;
            }
        }
        return true;
    }
}

package com.morris.augustchallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * Contains Duplicate 
 * 
 * Given an array of integers, find if the array contains any duplicates. Your function should 
 * return true if any value appears at least twice in the array, and it should return false if 
 * every element is distinct. 
 * 
 * @author Wali Morris
 * @since 08/12/2020
 */

public class Main {
    public static void main(String[] args) {
	    int[] A = {1, 2, 3, 1};
	    int[] B = {1, 2, 3, 4};
	    int[] C = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
	    boolean outputA = containsDuplicate(A);
        boolean outputB = containsDuplicate(B);
        boolean outputC = containsDuplicate(C);
        System.out.println(outputA);
        System.out.println(outputB);
        System.out.println(outputC);
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        for ( int i = 0; i < nums.length; i++ ) {
            /* record size of set before adding new element */ 
            int preSize = duplicates.size();
            duplicates.add(nums[i]);
            /* If set remains the same size this means the last element was not added, 
             * which indicates a duplicate. Return true. 
             */
            if (duplicates.size() == preSize) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Count Odd Numbers in an interval Range 
 * 
 * Given two non-negative integers low and high. return the count of odd numbers between low and high(inclusive). 
 * 
 * Solution : we know we can subtract high - low and receive the count of integers between these two variables. 
 * We also know that atleast half of those numbers between high - low will be odd(including low and high if they
 * are odd numbers). In this case we can subtract high from low, divide by 2 and add 1 if high is odd. If high 
 * is even: we can subtract high from low, add one to this difference to account for whole numbers and divide by 
 * two. 
 * 
 * @author Wali Morris
 * @since 08/12/2020
 */ 

public int countOdds(int low, int high) { 
    int solution = high % 2 != 0 ? (high-low)/2+1 : (high-low+1)/2; 
        return solution;  
    }
}

package com.morris.augustchallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * Contains Duplicates II
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the
 * array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * @author Wali Morris
 * @since 08/14/2020
 */

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        boolean outputA = containsNearbyDuplicate(nums1, k1);
        boolean outputB = containsNearbyDuplicate(nums2, k2);
        boolean outputC = containsNearbyDuplicate(nums3, k3);
        System.out.println(outputA);
        System.out.println(outputB);
        System.out.println(outputC);
    }

    /**
     * checkForDuplicatesSet is created and every iteration element nums[i] is added to set; this is fast since adding is
     * constant time. The current element and size of checkForDuplicatesSet is recorded. When adding the current element
     * to the set; if the set remains the same size this means we have a duplicate at nums[i]. At this point we should
     * check if the duplicate is in the range of nums[i] - nums[k] so we check k elements that have come before nums[i].
     * @param nums : The array being checked for duplicates
     * @param k : The range, less than current nums[i], which the duplicate should be found
     * @return : If a duplicate of nums[i] is found within range k, return true, else continue and possibly return false.
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> checkForDuplicatesSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int preSize = checkForDuplicatesSet.size();
            int currentNum = nums[i];
            checkForDuplicatesSet.add(currentNum);
            if (checkForDuplicatesSet.size() == preSize) {
                int dupK = k, reverse = i - 1;
                while ( dupK > 0) {
                    if ( nums[reverse] == currentNum) {
                        return true;
                    }
                    dupK--;
                    reverse--;
                }
            }
        }
        return false;
    }
}

package com.morris.augustchallenge;

/**
 * Check if N and its Double Exist
 *
 * Given an array arr of integers, check if there exists two integers N and M such that N is the
 * double of M ( i.e. N = 2 * M ).
 *
 * @author Wali Morris
 * @since 08/16/2020
 */

public class Main {
    public static void main(String[] args) {
        int[] A = {10, 2, 5, 3};
        int[] B = {7, 1, 14, 11};
        int[] C = {-2, 0, 10, -19, 4, 6, -8};
        boolean outputA = checkIfExist(A);
        boolean outputB = checkIfExist(B);
        boolean outputC = checkIfExist(C);
        System.out.println(outputA);
        System.out.println(outputB);
        System.out.println(outputC);
    }

    /**
     * Begin at index 0 in array and iterate until last element in array; this is n.
     * Nested loop begins at index 0 until last element in array iteration; this is m.
     * if element n and m are not the same index, if m equals n * 2; returns true.
     * @param arr : an array of integer elements 
     * @return : true or false
     */
    public static boolean checkIfExist(int[] arr) {
        for (int n = 0; n < arr.length; n++) {
            for (int m = 0; m < arr.length; m++) {
                if ( m != n && arr[m] == arr[n] * 2 ) {
                    return true;
                }
            }
        }
        return false;
    }
}

package com.morris.augustchallenge;

import java.util.Arrays;
import java.util.List;

/**
 * Goat Latin
 *
 * A sentence S is given, composed of words seperated by space. Each word consists of lowercase and uppercase letters
 * only. We would like to convert the sentence to "Goat Latin" ( made up language similar to Pig Latin). The rules :
 *
 * 1. If a word begins with a vowel (a, e, i, o, u), append "ma" to the end of the word.
 * 2. If a word begins with a consonant (not a vowel), remove the first letter and append it to the end, then add "ma".
 * 3. Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 *
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 * @author Wali Morris
 * @since 08/19/2020
 */

public class Main {
    public static void main(String[] args) {
        String A = "I speak Goat Latin";
        String B = "The quick brown fox jumped over the lazy dog";
        String outputA = toGoatLatin(A);
        String outputB = toGoatLatin(B);
        System.out.println(outputA);
        System.out.println(outputB);
    }

    public static String toGoatLatin(String s) {
        /* Splits string s into an array(stream) of words, initializes a empty StringBuilder object to translate the
         * sentence into Goat Latin. Establishes the list of vowels
         */
        String[] wordStream = s.split(" ");
        StringBuilder goatLatin = new StringBuilder();
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int i = 0;
        while ( i < wordStream.length ) {
            String word = wordStream[i];
            char firstCharacterOfWord = wordStream[i].charAt(0);
            /* checks if the current words first letter is a vowel. If so applies the first rule of Goat Latin.
             * Appends word and "ma", and extra 'a' characters for its index number. Lastly appends str to new
             * Goat Latin sentence translation.
             */
            if ( vowels.contains(firstCharacterOfWord) ) {
                StringBuilder str = new StringBuilder();
                str.append(word);
                str.append("ma");
                for ( int j = 0; j < i + 1; j++ ) {
                    str.append('a');
                }
                goatLatin.append(str);
            } else {
                /* applies rule two if the current word's first letter is not a vowel. Appends translated Goat Latin
                 * to new translated sentence.
                 */
                StringBuilder str = new StringBuilder();
                str.append(word.substring(1));
                str.append(firstCharacterOfWord);
                str.append("ma");
                for ( int j = 0; j < i + 1; j++ ) {
                    str.append('a');
                }
                goatLatin.append(str);
            }
            i++; // increments to next word
            if ( i != wordStream.length ) { // only append space to sentence if not last word. 
                goatLatin.append(" ");
            }
        }
        return goatLatin.toString();
    }
}

/**
 * Sort Array By Parity 
 * 
 * Given an Array A of non-negative integers, return an array consisting of all the even elements of A, followed by all 
 * the odd elements of A. You may return any answer array that satusfies this condition. 
 * 
 * NOTE: On leetcode this solution beats 99.96% of submissions according to speed of algorithm and uses less memory than 
 * 91% of submissions. It seems this solution is a bit more complex than it should be and in need of refactoring. 
 * 
 * @author Wali Morris 
 * @since 08/21/2020
 */
 
class Solution {
    public int[] sortArrayByParity(int[] A) {
        if ( A.length == 0 || A.length == 1 ) { 
            return A; 
        }
        int fPtr = 0, bPtr = A.length - 1; 
        do {
            if ( A[fPtr] % 2 == 0 && A[bPtr] % 2 == 0 ) { // both even 
                while ( A[fPtr] % 2 == 0 ) { // search for odd number
                    if ( bPtr == fPtr ) { 
                        return A;
                    }
                    fPtr++; // move right
                } 
                // makes a swap of back and front pointer once odd element is found  
                swap(A, fPtr, bPtr);   
            
	    } else if ( A[fPtr] % 2 != 0 && A[bPtr] % 2 != 0 ) { // both odd
                while ( A[bPtr] % 2 != 0 ) { // search for even number
                    if ( bPtr == fPtr ) { 
                        return A; 
                    }
                    bPtr--; // move left
                }
		// makes a swap of back and front pointer once even element is found 
                swap(A, fPtr, bPtr);  
            
            // front odd, back even
            } else { 
                if ( A[fPtr] % 2 != 0 && A[bPtr] % 2 == 0 ) { // simply swap
                    swap(A, fPtr, bPtr);  
                }
            }
            fPtr++; 
            bPtr--; 
        
        } while ( fPtr < bPtr );  
        return A; 
    } 
    
    // swaps two elements in an array 
    public static int[] swap(int[] A, int fPtr, int bPtr) { 
        int temp = A[fPtr]; 
        A[fPtr] = A[bPtr]; 
        A[bPtr] = temp;
        return A; 
    }
}

/**
 * Length of Last Word 
 * 
 * Given a String s consists of upper/lower-case alphabets and empty space characters ' , return the length of last word
 * (last word means the last appearing word if we loop from left to right) in the string. If the last word does not exist
 * return 0. 
 *
 * NOTE: This is my second time attempting this problem, the first time my algorithm was very slow only beating 30% of 
 * leetcode submissions. This solution's time complexity is fast, beating 100% of leetcode submissions.
 *
 * @author Wali Morris
 * @since 08/22/2020
 */ 

class Solution {
    public int lengthOfLastWord(String s) {
        if ( s.length() == 0 ) { 
            return 0; 
        }  
        /* ignores trailing spaces in last word in string. The intent is to take the 
         * last word and only count characters that are letters. */ 
        int last = s.length() - 1; 
        if ( s.charAt(last) == ' ' ) { 
            while ( s.charAt(last) == ' ' ) { 
                if ( last == 0 ) { 
                    return 0; 
                }
                last--; 
            }
        }
        /* Builds a string containing only the letters of the last word in string. 
         * Once the next word is seen, break and return the length of last word */ 
        StringBuilder str = new StringBuilder();
        while ( s.charAt(last) != ' ' ) { 
            str.append(s.charAt(last)); 
            if ( last == 0 ) { 
                break; 
            }
            last--; 
        } 
        return str.toString().length(); 
    } 
} 

package com.morris.augustchallenge;

/**
 * Longest Continuous Increasing Subsequence
 *
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * @author Wali Morris
 *
 */

public class Main {
    public static void main(String[] args) {
	    int[] A = {1, 3, 5, 4, 7};
	    int[] B = {2, 2, 2, 2, 2};
	    int outputA = findLengthOfLCIS(A);
        int outputB = findLengthOfLCIS(B);
        System.out.println(outputA);
        System.out.println(outputB);
    }

    public static int findLengthOfLCIS(int[] nums) {
        /* Return arrays of length 0 or 1 as is */ 
        if ( nums.length < 2 ) {
            return nums.length;
        }
        int count = 1, maxCount = 0;
        for ( int i = 0; i < nums.length - 1; i++ ) {
            /* increment count as long as the next number is greater */ 
            if ( nums[i + 1] > nums[i] ) {
                count++;
            } else {
                /* continuous stream has been broken, if count is greater than maxCount then 
                 * maxCount becomes current count. Else keep the current maxCount. */ 
                maxCount = Math.max(count, maxCount);
                count = 1;
            }
        }
        /* returns the greater of count and maxCount */ 
        return Math.max(count, maxCount);
    }
}

package com.morris.augustchallenge;

/**
 * Shuffle String
 *
 * Given a string s and an integer array indices of the same length
 *
 * The string s will be shuffled such that the character at the ith position
 * moves indices[i] in the shuffled string
 *
 * return the shuffled string
 *
 * @author Wali Morris
 * @since 08/24/2020
 */

public class Main {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        String output = restoreString(s, indices);
        System.out.println(output);
    }

    public static String restoreString(String s, int[] indices) {
        char[] result = new char[s.length()];
        for ( int i = 0; i < indices.length; i++ ) {
            result[indices[i]] = s.charAt(i);
        }
        return new String(result);
    }
}

package com.morris.augustchallenge;

/**
 * Three Consecutive Odds
 *
 * Given an integer array arr, return true if there are three consecutive odd numbers in the
 * array. Otherwise, return false.
 * 
 * @author Wali Morris
 * @since 08/24/2020
 */

public class Main {

    public static void main(String[] args) {
	    int[] A = {2, 4, 6, 1, 3, 5};
	    boolean output = threeConsecutiveOdds(A);
	    System.out.println(output);
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        if ( arr.length < 3 ) {
            return false; // return false for any array less than three
        }
        int count = 0;
        for ( int j : arr ) {
            if ( j % 2 != 0 ) { // element odd, add to count
                count++;
                if ( count == 3 ) { // count = 3, return true
                    return true;
                }
            } else { // element is even, reset count
                count = 0;
            }
        }
        return false; // condition not met
    }
}

package com.morris.augustchallenge;

/**
 * Maximum Number of Balloons
 * 
 * Given a String text, you want to use the characters of text to form as many instances of the word "balloon" as 
 * possible. You can use each character in text at most once. Return the maximum number of instances that can be 
 * formed. 
 * 
 * @author Wali Morris
 * @since 08/25/2020
 */

public class Main {
    public static void main(String[] args) {
	    String A = "nlaebolko";
	    String B = "loonbalxballpoon";
	    String C = "leetcode";
	    int outputA = maxNumberOfBalloons(A);
	    int outputB = maxNumberOfBalloons(B);
	    int outputC = maxNumberOfBalloons(C);
	    System.out.println(outputA);
	    System.out.println(outputB);
	    System.out.println(outputC);
    }

    public static int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        int count = 0;

        /* runs through length of text and tallies every character, once if condition has been meet, increment count
         * and subtract 1 from each letter count in balloon( but 2 for 'o' and 'l').
         */
        for ( int i = 0; i < text.length(); i++ ) {
            char character = text.charAt(i);
            switch ( character ) {
                case 'b': b++; break;
                case 'a': a++; break;
                case 'l': l++; break;
                case 'o': o++; break;
                case 'n': n++;break;
            }
            // Must be another way I can do this, this conditional statement slows down the process significantly enough.
            if ( b >= 1 && a >= 1 && l >= 2 && o >= 2 && n >= 1 ) {
                count++;
                b--;
                a--;
                l-=2;
                o-=2;
                n--;
            }
        }
        return count;
    }
}
/** 
 * Fizz Buzz 
 * 
 * Write a program that outputs the string representation of numbers from 1 to n. But for multiples of three it should 
 * output "Fizz" instead of the number and for the multiples of five output "Buzz". For numbers which are multiples of 
 * both three and five output "FizzBuzz". 
 * 
 * @author Wali Morris
 * @since 08/27/2020
 */ 
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> fizzyBuzzList = new ArrayList<>(); 
        int i = 1; 
        while ( i <= n ) { 
            if ( i % 3 == 0 && i % 5 != 0 ) { 
                fizzyBuzzList.add("Fizz"); 
            } else if ( i % 3 != 0 && i % 5 == 0 ) { 
                fizzyBuzzList.add("Buzz"); 
            } else if ( i % 3 == 0 && i % 5 == 0 ) { 
                fizzyBuzzList.add("FizzBuzz"); 
            } else { 
                fizzyBuzzList.add(String.valueOf(i)); 
            }
            i++; 
        }
        return fizzyBuzzList; 
    }
}

/**
 * Thousand Separator 
 * 
 * Given an integer n, add a dot (".") as the thousands separator and return it in string format. 
 * Note: There are two solutions here. The first solution utilizes a StringBuilder to build the 
 * string and then reverse it. The second solution utilizes the substring method, which is much 
 * slower. I'm recording the solution because it'll be cool to utilize the substring method and 
 * produce an optimal solution. 
 * 
 * @author Wali Morris 
 * @since 08/30/2020
 */ 

class Solution1 {
    public String thousandSeparator(int n) {
        String nStr = String.valueOf(n); 
        if ( nStr.length() < 4 ) {                      // returns String n if digits less than 4  
            return nStr; 
        }
        int range = nStr.length() -1, count = 0;        // record length of number, initialize count 
        StringBuilder str = new StringBuilder();        // new StringBuilder object 
        while ( range >= 0 ) {                          // while first character hasn't been reached
            if ( count == 3 ) {                         // starting from the last digit in nStr
                str.append(".");                        // if count equals 3 append a dot 
                count = 0;                              // reset count to 0
            } else {                                    // count is not 3  
                str.append(nStr.charAt(range));         // append character at nStr[range]
                count++;                                // increment count  
                range--;                                // move to next digit to the left in nStr
            } 
        } 
        return str.reverse().toString();                // return reversed built string 
    } 
}

// This is the substring solution which is not optimized and much slower than the StringBuilder solution, but was 
// my first solution and another way to do it. Thought I'd share and record the substring solution. It'd be cool if 
// there's a way to make the substring solution optimal. 

class Solution2 {
    public String thousandSeparator(int n) {    
        String nStr = String.valueOf(n); 
        if ( nStr < 4 ) { 
            return nStr;                                 // returns digit with length < 4
        }                                                // starting from the last digit 
        int nLength = nStr.length();                     // record digit length 
        while ( nLength > 3 ) {                          // while length > 3
            String beg = nStr.substring(0, nLength - 3); // substring beginning, excluding end
            String end = nStr.substring(nLength - 3);    // substring end, rest of nStr
            nStr = beg + "." + end;                      // concatenate beg and end while adding a "."
            nLength -= 3;                                // move three characters to the left 
        } 
        return nStr;                                     // returns the string with dots
    }
}

import java.util.*;

/**
 * Reverse Vowels of a String
 *
 * Write a method that takes a string as input and reverse only the vowels of a string.
 *
 * @author Wali Morris
 * @since 09/06/2020
 */

public class ReverseVowels2 {
    public static void main(String[] args) {
        String A = "hello";
        String B = "leetcode";
        String outputA = reverseVowels(A);
        String outputB = reverseVowels(B);
        System.out.println(outputA);
        System.out.println(outputB);
    }

    public static String reverseVowels(String s) {
        if ( s.length() == 0 || s.length() == 1 ) {
            return s;
        }
        StringBuilder s2 = new StringBuilder(s);
        String vowels = "aeiouAEIOU";
        int ptr1 = 0, ptr2 = s2.toString().length() - 1;                                                                   // begin pointers at opposite ends of string s to begin reading for vowels 
	while ( ptr1 <= ptr2 ) {
            if ( vowels.indexOf(s2.toString().charAt(ptr1)) != -1  && vowels.indexOf(s2.toString().charAt(ptr2)) != -1 ) { // both pointers are pointing at a vowel, flip the vowels to the other
                char temp = s2.toString().charAt(ptr1);                                                                    // initialize a temporary character to hold the first character at pointer 1
                s2.setCharAt(ptr1, s2.toString().charAt(ptr2));
                s2.setCharAt(ptr2, temp);
                ptr1++;                                                                                                    // go to next character to right 
                ptr2--;                                                                                                    // go to next character to left
            } else if ( vowels.indexOf(s2.charAt(ptr1)) != -1 && vowels.indexOf(s2.charAt(ptr2)) == -1 )  {                // do not flip but move ptr2 left to next character
                ptr2++;                      
            } else if ( vowels.indexOf(s2.charAt(ptr1)) == -1 && vowels.indexOf(s2.charAt(ptr2)) != -1 ) {                 // do not flip but move ptr1 right to next character
                ptr1++;                                                                                 
            } else {                                                                                                       // both characters are not vowels continue
                ptr1++;
                ptr2--;
            }
        }
        return s2.toString();
    }
}

/**
 * Best Time to Buy and Sell Stocks
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i. If you were only permitted to complete
 * at most one transaction ( buy one and sell on share of stock), design an algorithm to find the maximum profit. Note: you cannot 
 * sell a stock before you buy one. 
 * 
 * @author Wali Morris 
 * @since 09/18/2020
 */

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;                                         // initialize profit to zero dollars
        for ( int i = 0; i < prices.length; i++ ) {                // outer loop begins
            int buy = prices[i];                                   // buying price
            for ( int j = i; j < prices.length; j++ ) {            // inner loop begins 
                int sell = prices[j];                              // selling price 
                if ( j > i && sell > buy ) {                       // selling price is after buying price and selling price is higher
                   maxProfit = Math.max(maxProfit, sell - buy);    // take the highest profit so far
                } 
            } 
        } 
        return maxProfit;                                          // return max profit 
    } 
} 

package com.morris.leetcode;

import java.util.Arrays;

/**
 * Remove Duplicates From Sorted Array - In Place
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element
 * appears only once and returns the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the
 * input array in-place with O(1) extra memory.
 *
 * @author Wali Morris
 *
 */

public class Main {
    public static void main(String[] args) {
        int[] A = {1, 1, 2};
        int[] B = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int outputA = removeDuplicates(A);
        int outputB = removeDuplicates(B);
        System.out.println(outputA);
        System.out.println(outputB);
    }

    /* Note: It does not matter the elements in the array after the new length has been
     * found as long as the non-duplicate numbers are moved to their proper place in the
     * array.. ie print the new array and it should contain no duplicates and be sorted
     * up until the new length.
     */
    public static int removeDuplicates(int[] nums) {
        /* If nums is length 0 or length 1 return the length. No way there's a duplicate. */
        if ( nums.length < 2 ) {
            return nums.length;
        }
        /* record current element, current index, and count which begins at one because any
         * duplicate of current element will not be counted.
         */
        int current = nums[0], old = 0, count = 1;
        for ( int i = 1; i < nums.length; i++ ) {
            if ( nums[i] != current ) {       // element is not a duplicate of current element
                current = nums[i];            // element becomes current
                nums[old + 1] = nums[i];      // move new current element one index right of old current
                old++;                        // go to index of new current
                count += 1;                   // increment count
            }
        }
        return count;
    }
}

package com.morris.leetcode;

/**
 * BRUTE FORCE SOLUTION:
 *
 * Determine weather an Integer is a palindrome. An Integer is a palindrome when
 * it reads the same backwards as forwards.
 * 
 * @author Wali Morris
 * @since 10/09/2020
 */

public class Main {
    public static void main(String[] args) {
        int A = 121;
        int B = -121;
        int C = 10;
        int D = -10;

        boolean outputA = isPalindrome(A);
        boolean outputB = isPalindrome(B);
        boolean outputC = isPalindrome(C);
        boolean outputD = isPalindrome(D);

        System.out.println(outputA);
        System.out.println(outputB);
        System.out.println(outputC);
        System.out.println(outputD);
    }

    /**
     * Determines if a integer is a palindrome, that is, it reads backwards the
     * same as forwards. Parses Integer to String and builds a string in reverse
     * using {@link StringBuilder} and compares original value to new StringBuilder.
     *
     * @param x the integer to read.
     * @return boolean
     */
    public static boolean isPalindrome(int x) {
        if ( x < 0 ) {
            return false;
        }
        StringBuilder nStr = new StringBuilder(Integer.toString(x));
        try {
            return Integer.parseInt(nStr.reverse().toString()) == x;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

package com.morris.leetcode;

/**
 * Design Parking System
 *
 * Design a parking system for a parking lot. The parking lot has three kinds of parking spaces:
 * big, medium, and small, with a fixed number of slots for each size.
 *
 * Implement the Parking System Class:
 *
 * - ParkingSystem(int big, int medium, int small) initializes object of the ParkingSystem class.
 * the number of slots for each parking space are given as part of the constructor.
 *
 * - bool addCar(int carType) Checks whether there is a parking space of carType for the car that
 * wants to get into the parking lot. carType can be of three kinds: big, medium, small which are
 * represented by 1, 2, 3 respectively. A car can only park in a parking space of its carType. If
 * there is no space available, return false, else park the car in that size space and return true.
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

public class Main {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }
}

package com.morris.leetcode;

public class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (this.big == 0) {
                    return false;
                } else {
                    decrementBig();
                }
                break;

            case 2:
                if (this.medium == 0) {
                    return false;
                } else {
                    decrementMedium();
                }
                break;

            default:
                if (this.small == 0) {
                    return false;
                } else {
                    decrementSmall();
                }
                break;
        }
        return true;

    }
    private void decrementBig() {
        this.big = this.big - 1;
    }

    private void decrementMedium() {
        this.medium = this.medium - 1;
    }

    private void decrementSmall() {
        this.small = this.small - 1;
    }
}

package com.morris.leetcode;

import java.util.Arrays;

/**
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount 
 * of money of the ith customer has in the jth bank. Return the wealth that the 
 * richest customer has. 
 * 
 * A customer's wealth is the amount of money they have in their bank accounts. The 
 * richest customer is the customer that has the maximum wealth. 
 * 
 * @author Wali Morris<walimmorris@gmail.com>
 */
public class Main {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {3, 2, 1}};
        int output = maxWealth(A);
        System.out.println(output);
    }

    public static int maxWealth(int[][] accounts) {
        // Stream the arrays
        return Arrays.stream(accounts)
                // for every array in the array, get the sum
                .mapToInt(account -> Arrays.stream(account).sum())
                // get max of all sums
                .max()
                .getAsInt();
    }
}

package com.morris.leetcode;

/**
 * You own a Goal Parser that can interpret a string command. The command consists of an 
 * alphabet of "G", "()", and/or "(al)" in some order. The Goal Parser will interpret "G"
 * as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted 
 * strings are then concatenated in the original order. 
 * 
 * Given the string command, return the Goal Parser's interpretation of command. 
 * 
 * @author Wali Morris<walimmorris@gmail.com>
 */

public class Main {

    public static void main(String[] args) {
        String command1 = "G()(al)";
        String command2 = "G()()()()(al)";
        String command3 = "(al)G(al)()()G";

        String output1 = interpret(command1);
        String output2 = interpret(command2);
        String output3 = interpret(command3);

        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
    }

    public static String interpret(String command) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < command.length(); i++ ) {
            if (command.charAt(i) == 'G') {
                output.append(command.charAt(i));
            } else if (command.startsWith("()", i)) {
                output.append("o");
                i++;
            } else {
                if (command.startsWith("(al)", i)) {
                    output.append("al");
                    i += 3;
                }
            }
        }
        return output.toString();
    }
}

package com.morris.leetcode;

/**
 * Given an integer n and an integer start. Define an array nums where 
 * nums[i] = start + 2 * 1 (0-indexed) and n == nums.length. 
 * 
 * Return the bitwise XOR of all elements of nums. 
 * 
 * @author Wali Morris<walimmorris@gmail.com>
 */

public class Main {

    public static void main(String[] args) {
        int n1 = 5, start1 = 0;
        int output1 = xorOperation(n1, start1);
        System.out.println(output1);
    }

    public static int xorOperation(int n, int start) {
        int[] array = new int[n];
        array[0] = start;
        for ( int i = 1; i < n; i++ ) {
            start += 2;
            array[i] = start;
            array[0] = array[0] ^ array[i];
        }
        return array[0];
    }
}

package com.morris.kata;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String A = "abc";
        String B = "abcdef";

        System.out.println(Arrays.toString(solution(A)));
        System.out.println(Arrays.toString(solution(B)));
    }

    public static String[] solution(String s) {
        if (s.length() == 0) {
            return new String[0];
        }
        String[] output = s.length() % 2 == 0 ? new String[s.length() / 2] : new String[s.length() / 2 + 1];
        int j = 0;
        for (int i = 0; i < output.length; i++) {
            String a = String.valueOf(s.charAt(j));
            if (j == s.length() - 1) {
                String b = "_";
                String str = a + b;
                output[i] = str;
            } else {
                String b = String.valueOf(s.charAt(j + 1));
                String str = a + b;
                output[i] = str;
                j+=2;
            }
        }
        return output;
    }
}

package com.morris.leetcode;

/**
 * You are given a string allowed consisting of distinct characters and an array of strings
 * 'words'. A String is consistent if all characters in the string appear in the string
 * 'allowed'.
 *
 * Return the number of consistent strings in the array words.
 *
 * @author Wali
 */

public class Main {
    public static void main(String[] args) {
        String allowed1 = "ab";
        String[] words1 = {"ad", "bd", "aaab", "baa", "badab"};

        String allowed2 = "abc";
        String[] words2 = {"a", "b", "c", "ab", "ac", "bc", "abc"};

        String allowed3 = "cad";
        String[] words3 = {"cc", "acd", "b", "bac", "bad", "ac", "d"};

        int output1 = countConsistentString(allowed1, words1);
        int output2 = countConsistentString(allowed2, words2);
        int output3 = countConsistentString(allowed3, words3);

        System.out.println("Allowed1: " + output1);
        System.out.println("Allowed2: " + output2);
        System.out.println("Allowed3: " + output3);
    }

    public static int countConsistentString(String allowed, String[] words) {
        int consistentStrings = 0;
        for (String word : words) {
            boolean inconsistentLetterFound = false;
            for (int j = 0; j < word.length(); j++) {
                if (!(allowed.contains(String.valueOf(word.charAt(j))))) {
                    inconsistentLetterFound = true;
                    break;
                }
            }
            if (!inconsistentLetterFound) {
                consistentStrings++;
            }
        }
        return consistentStrings;
    }
}
