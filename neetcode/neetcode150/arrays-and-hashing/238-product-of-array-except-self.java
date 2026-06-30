/*
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 * NeetCode: Arrays & Hashing — Medium
 *
 * Notes:
 * - Return array where output[i] = product of all nums except nums[i].
 * - Follow-up: solve without division — use prefix/suffix products.
 */

import java.util.*;

// ── Approach 1: Total Product + Division (2-zero shortcut) ─
// Time: O(n) | Space: O(1) excluding output
// Idea: Compute full product; divide by nums[i]. Special-case zeros.
//       Early exit if 2+ zeros — answer is all zeros.

class Solution_TotalProductEarlyExit {
    public int[] productExceptSelf(int[] nums) {
        if (Arrays.stream(nums).filter(x -> x == 0).limit(2).count() == 2) {
            return new int[nums.length];
        }

        int product = 1;
        for (int num : nums) {
            if (num == 0) {
                product = 0;
                break;
            }
            product *= num;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[i] = product / nums[i];
            } else {
                result[i] = productExceptIndex(nums, i);
            }
        }
        return result;
    }

    private int productExceptIndex(int[] nums, int skip) {
        int product = 1;
        for (int j = 0; j < nums.length; j++) {
            if (j != skip) {
                product *= nums[j];
            }
        }
        return product;
    }
}

// ── Approach 2: Total Product + Division ─────────────────
// Time: O(n) | Space: O(1) excluding output
// Idea: Same as Approach 1 without the 2-zero early exit.

class Solution_TotalProduct {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        for (int num : nums) {
            if (num == 0) {
                product = 0;
                break;
            }
            product *= num;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[i] = product / nums[i];
            } else {
                result[i] = productExceptIndex(nums, i);
            }
        }
        return result;
    }

    private int productExceptIndex(int[] nums, int skip) {
        int product = 1;
        for (int j = 0; j < nums.length; j++) {
            if (j != skip) {
                product *= nums[j];
            }
        }
        return product;
    }
}

// ── Optimal (submit this on NeetCode): Approach 2 ────────
// (NeetCode also teaches prefix/suffix without division — add when you solve it.)
