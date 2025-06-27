package Array.Sliding_Window;

import java.util.HashMap;

// https://www.naukri.com/code360/problems/distinct-characters_2221410

class Solution {

    public static int kDistinctChars(int k, String str) {
        int res = 0;
        int lastPtr = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            map.put(str.charAt(i), map.containsKey(str.charAt(i)) ? map.get(str.charAt(i)) + 1 : 1);

            while (map.size() > k && lastPtr <= i) {

                map.put(str.charAt(lastPtr),
                        map.containsKey(str.charAt(lastPtr)) ? map.get(str.charAt(lastPtr)) - 1 : 1);
                if (map.get(str.charAt(lastPtr)) == 0)
                    map.remove(str.charAt(lastPtr));
                lastPtr++;
            }
            res = Math.max(res, i - lastPtr + 1);
        }
        return res;
    }

}