/*
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 * NeetCode: Arrays & Hashing — Easy
 *
 * Notes:
 * - Return true if any value appears at least twice.
 */

import java.util.*;

// ── Approach 1: Brute Force ──────────────────────────────
// Time: O(n²) | Space: O(1)
// Idea: Compare every pair.

class Solution_BruteForce {
    public boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}

// ── Approach 2: Hash Set ─────────────────────────────────
// Time: O(n) | Space: O(n)
// Idea: Track seen elements; duplicate found on second sighting.

class Solution_HashSet {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) return true;
        }
        return false;
    }
}

// ── Approach 3: Stream (one-liner) ─────────────────────
// Time: O(n) | Space: O(n)
// Idea: distinct count < length. Clever but not interview-friendly.

class Solution_Stream {
    public boolean hasDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}

// ── Optimal (submit this on NeetCode): Approach 2 ────────
