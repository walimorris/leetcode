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
