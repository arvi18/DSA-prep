/*
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * NeetCode: Arrays & Hashing — Medium
 *
 * Notes:
 * - Group strings that are anagrams of each other.
 * - Key insight: anagrams share the same "signature" (sorted string or char counts).
 */

import java.util.*;

// ── Approach 1: Sorted String as Key ─────────────────────
// Time: O(n * k log k) | Space: O(n * k)  — k = max word length
// Idea: Sort each word; use sorted form as HashMap key.

class Solution_SortedKey {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedToWords = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            List<String> group = sortedToWords.getOrDefault(key, new ArrayList<>());
            group.add(word);
            sortedToWords.put(key, group);
        }

        return new ArrayList<>(sortedToWords.values());
    }
}

// ── Approach 2: Char Count as Key ────────────────────────
// Time: O(n * k) | Space: O(n * k)
// Idea: Build int[26] frequency per word; use Arrays.toString(counts) as key.

class Solution_CountKey {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> countToWords = new HashMap<>();

        for (String word : strs) {
            int[] counts = new int[26];
            for (char c : word.toCharArray()) {
                counts[c - 'a']++;
            }
            String key = Arrays.toString(counts);

            List<String> group = countToWords.getOrDefault(key, new ArrayList<>());
            group.add(word);
            countToWords.put(key, group);
        }

        return new ArrayList<>(countToWords.values());
    }
}

// ── Optimal (submit this on NeetCode): Approach 2 ────────
