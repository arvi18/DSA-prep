/*
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 * NeetCode: Arrays & Hashing — Easy
 *
 * Notes:
 * - Return true if t is an anagram of s (same chars, same counts).
 */

import java.util.*;

// ── Approach 1: HashMap Helper ───────────────────────────
// Time: O(n) | Space: O(1) — at most 26 distinct chars
// Idea: Build a frequency map for each string, then compare.

class Solution_MapHelper {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        return charCountMap(s).equals(charCountMap(t));
    }

    private Map<Character, Integer> charCountMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}

// ── Approach 2: Sort ───────────────────────────────────────
// Time: O(n log n) | Space: O(n)
// Idea: Anagrams have identical sorted char sequences.

class Solution_Sort {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }
}

// ── Approach 3: Two HashMaps ───────────────────────────────
// Time: O(n) | Space: O(1)
// Idea: Count chars in both strings separately, then compare maps.

class Solution_TwoHashMaps {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }
}

// ── Approach 4: Fixed-Size Frequency Array ───────────────
// Time: O(n) | Space: O(1)
// Idea: Increment for s, decrement for t; all counts must be zero.

class Solution_FrequencyArray {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) return false;
        }
        return true;
    }
}

// ── Optimal (submit this on NeetCode): Approach 4 ────────
