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
