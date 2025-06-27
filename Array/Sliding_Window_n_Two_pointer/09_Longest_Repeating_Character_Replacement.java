package Array.Sliding_Window_n_Two_pointer;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int lastPtr = 0;
        int res = 0;
        int maxFreq = 0;

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.containsKey(s.charAt(i)) ? map.get(s.charAt(i)) + 1 : 1);

            if (map.get(s.charAt(i)) > maxFreq)
                maxFreq = map.get(s.charAt(i));

            while ((i - lastPtr + 1) - maxFreq > k && lastPtr <= i) {
                map.put(s.charAt(lastPtr), map.containsKey(s.charAt(lastPtr)) ? map.get(s.charAt(lastPtr)) - 1 : 0);
                if (map.get(s.charAt(lastPtr)) == 0)
                    map.remove(s.charAt(lastPtr));

                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > maxFreq)
                        maxFreq = entry.getValue();
                }
                lastPtr++;
            }
            res = Math.max(res, i - lastPtr + 1);
        }
        return res;
    }
}