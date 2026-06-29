/*
 * 271. Encode and Decode Strings
 * https://leetcode.com/problems/encode-and-decode-strings/
 * NeetCode: Arrays & Hashing — Medium
 *
 * Notes:
 * - Design encode/decode so any list of strings round-trips correctly.
 * - Delimiters can appear inside strings — length-prefix avoids ambiguity.
 */

import java.util.*;
import java.util.stream.Collectors;

// ── Approach 1: Custom Delimiter ───────────────────────────
// Time: O(n) encode/decode | Space: O(output)
// Idea: Join with " @|@ "; sentinel for empty list. Fragile if delimiter appears in input.

class Solution_Delimiter {
    private static final String DELIMITER = " @|@ ";
    private static final String EMPTY_SENTINEL = "safekeyword";

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return EMPTY_SENTINEL;
        return strs.stream().collect(Collectors.joining(DELIMITER));
    }

    public List<String> decode(String str) {
        if (EMPTY_SENTINEL.equals(str)) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(str.split(" @\\|@ ", -1)));
    }
}

// ── Approach 2: Length-Prefix ──────────────────────────────
// Time: O(n) encode/decode | Space: O(output)
// Idea: Encode each string as {length}#{chars}; parse length then slice substring.

class Solution_LengthPrefix {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}

// ── Optimal (submit this on NeetCode): Approach 2 ────────
