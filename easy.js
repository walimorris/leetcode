/**
 * You are given an integer array nums. Let product be the product 
 * of all values in the array nums. Return -1 if sign is negative, 
 * 0 if product is 0 and 1 if sign is postive.
 * @param nums : array
 * @returns {number}
 * @author Wali Morris<walimmorris@gmail.com>
 */
let arraySign = function (nums) {
    let count = 1;
    for (let i = 0; i < nums.length; i += 1) {
        if (nums[i] === 0) {
            return 0;
        }
        let x = nums[i] > 0 ? 1 : -1;
        count *= x;
    }
    if (count < 0) {
        return -1;
    } else {
        return 1;
    }
}

/**
 * You are given an array items, where each items[i] = [type, color, name]
 * describes the type, color and name of the ith item. You are also given 
 * a rule represented by two strings, ruleKey and ruleValue. The ith item 
 * is said to match the rule if one of the following is true: 
 *     
 *     `ruleKey === "type" && ruleValue === type(i)`
 *     `ruleKey === "color" && ruleValue === color(i)`
 *     `ruleKey === "name" && ruleValue === name(i)`
 * 
 * Return the number of items that match the given rule.    
 * @param items
 * @param ruleKey
 * @param ruleValue
 * @returns {number}
 * @author Wali Morris<walimmorris@gmail.com>
 */
let countMatches = function(items, ruleKey, ruleValue) {
    let match = 0;
    for (let i = 0; i < items.length; i += 1) {
        for (let j = 0; j < items[i].length; j += 1) {
            if (j === 0 && ruleKey === "type") {
                match = items[i][j] === ruleValue ? match += 1 : match;
            } else if (j === 1 && ruleKey === "color") {
                match = items[i][j] === ruleValue ? match += 1 : match;
            } else {
                if (j === 2 && ruleKey === "name") {
                    match = items[i][j] === ruleValue ? match += 1 : match;
                }
            }
        }
    }
    return match;
}

/**
 * A Panagram is a sentence where every letter of the English Alphabet appears 
 * at least once. Given a string `sentence` containing only lowercase English 
 * letters, return true if `sentence` is a panagram, or false otherwise.
 * @param sentence
 * @returns {boolean}
 * @author Wali Morris<walimmorris@gmail.com>
 */
const checkIfPanagram = function (sentence) {
    let set = new Set();
    for (let i = 0; i < sentence.length; i += 1) {
        set.add(sentence.charAt(i));

        // 26 unique english letters have been found
        if (set.size === 26) {
            return true;
        }
    }
    return false;
}
