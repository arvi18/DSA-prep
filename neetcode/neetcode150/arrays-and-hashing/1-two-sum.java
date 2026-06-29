/*
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 * NeetCode: Arrays & Hashing — Easy
 *
 * Notes:
 * - Return indices of two numbers that add up to target.
 * - Exactly one solution exists; cannot use the same element twice.
 */

import java.util.*;

// ── Approach 1: Brute Force ──────────────────────────────
// Time: O(n²) | Space: O(1)
// Idea: Check every pair.

class Solution_BruteForce {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

// ── Approach 2: HashMap (two-pass) ───────────────────────
// Time: O(n) | Space: O(n)
// Idea: Map value → index; for each num, check if complement exists at a different index.

class Solution_HashMap {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>(); // val -> index

        for (int i = 0; i < nums.length; i++) {
            indices.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (indices.containsKey(diff) && indices.get(diff) != i) {
                return new int[]{i, indices.get(diff)};
            }
        }

        return new int[0];
    }
}

// ── Approach 3: HashMap + Remove Current ─────────────────
// Time: O(n) | Space: O(n)
// Idea: Build map first; on second pass, remove current entry before
//       looking up complement — avoids reusing the same index.

class Solution_HashMapRemove {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>(); // val -> index

        for (int i = 0; i < nums.length; i++) {
            indices.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            indices.remove(nums[i], i); // don't match against self
            if (indices.get(complement) != null) {
                return new int[]{i, indices.get(complement)};
            }
        }

        return new int[0];
    }
}

// ── Optimal (submit this on NeetCode): Approach 3 ────────
