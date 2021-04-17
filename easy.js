/**
 * You are given an integer array nums. Let product be the product 
 * of all values in the array nums. Return -1 if sign is negative, 
 * 0 if product is 0 and 1 if sign is postive.
 * @param nums : array
 * @returns {number}
 * @author <walimmorris@gmail.com>
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
