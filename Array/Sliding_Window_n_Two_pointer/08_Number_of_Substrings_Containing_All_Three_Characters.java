package Array.Sliding_Window_n_Two_pointer;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

class Solution {
    public int numberOfSubstrings(String s) {

        int res = 0;
        int lastPtr = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i), map.containsKey(s.charAt(i)) ? map.get(s.charAt(i)) + 1 : 1);

            while (map.size() == 3 && lastPtr <= i) {
                res += 1 + s.length() - 1 - i;
                map.put(s.charAt(lastPtr), map.get(s.charAt(lastPtr)) - 1);

                if (map.get(s.charAt(lastPtr)) == 0)
                    map.remove(s.charAt(lastPtr));

                lastPtr++;
            }
        }
        return res;
    }
}
