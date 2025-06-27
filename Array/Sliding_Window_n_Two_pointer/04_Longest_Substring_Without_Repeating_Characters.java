package Array.Sliding_Window;

import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int lastPtr = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {

                while (s.charAt(i) != s.charAt(lastPtr) && lastPtr <= i) {
                    map.remove(s.charAt(lastPtr));
                    lastPtr++;
                }
                map.remove(s.charAt(i));
                lastPtr++;
            }
            map.put(s.charAt(i), 1);
            res = Math.max(res, i - lastPtr + 1);
        }
        return res;
    }
}