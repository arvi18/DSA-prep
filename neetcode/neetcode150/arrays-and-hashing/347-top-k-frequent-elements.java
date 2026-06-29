/*
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 * NeetCode: Arrays & Hashing — Medium
 *
 * Notes:
 * - Return the k most frequent elements (any order).
 */

import java.util.*;
import java.util.stream.Collectors;

// ── Approach 1: Sort by Frequency (Collections.sort) ─────
// Time: O(n + u log u) | Space: O(u)  — u = unique elements
// Idea: Count frequencies, sort entries by count descending, take top k keys.

class Solution_SortCollections {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreqMap = new HashMap<>();
        for (int num : nums) {
            numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> mapList =
            numFreqMap.entrySet().stream().collect(Collectors.toList());
        Collections.sort(mapList, Map.Entry.<Integer, Integer>comparingByValue().reversed());

        List<Map.Entry<Integer, Integer>> finalList = mapList.subList(0, k);
        return finalList.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}

// ── Approach 2: Sort by Frequency (List.sort) ──────────
// Time: O(n + u log u) | Space: O(u)
// Idea: Same as Approach 1; in-place sort on the collected list.

class Solution_SortInPlace {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFreqMap = new HashMap<>();
        for (int num : nums) {
            numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> mapList =
            numFreqMap.entrySet().stream().collect(Collectors.toList());
        mapList.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        return mapList.subList(0, k).stream().mapToInt(Map.Entry::getKey).toArray();
    }
}

// ── Approach 3: Min Heap of Size k ───────────────────────
// Time: O(n + u log k) | Space: O(u + k)
// Idea: Keep k largest frequencies in a min heap; root is smallest of the top k.

class Solution_MinHeap {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min heap by freq
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }
}

// ── Optimal (submit this on NeetCode): Approach 3 ────────
