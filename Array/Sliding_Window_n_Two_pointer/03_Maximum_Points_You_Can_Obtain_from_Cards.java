package Array.Sliding_Window_n_Two_pointer;

// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int res = 0;
        int lastPtr = cardPoints.length - 1;

        for (int i = 0; i < k; i++)
            res += cardPoints[i];

        int currRes = res;

        for (int i = 0; i < k; i++) {

            currRes = currRes + cardPoints[lastPtr] - cardPoints[k - 1 - i];
            lastPtr--;

            res = Math.max(res, currRes);
        }
        return res;

    }
}