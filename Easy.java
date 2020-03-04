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
