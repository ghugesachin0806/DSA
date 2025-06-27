package Array.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fruit-into-baskets/

// Max length of subarray with at most 2 types of numbers.

class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int lastPtr = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.containsKey(fruits[i]) ? map.get(fruits[i]) + 1 : 1);

            while (map.size() > 2 && lastPtr <= i) {
                int temp = map.get(fruits[lastPtr]);
                temp--;
                map.put(fruits[lastPtr], temp);
                if (temp == 0) {
                    map.remove(fruits[lastPtr]);
                }
                lastPtr++;
            }
            res = Math.max(res, i - lastPtr + 1);
        }
        return res;
    }
}
