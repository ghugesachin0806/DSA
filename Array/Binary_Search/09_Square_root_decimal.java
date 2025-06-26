package Array.Binary_Search;

// https://www.naukri.com/code360/problems/square-root-decimal_1095655

class Solution {

    public static double solve(long temp, long n, int d) {
        double ans = temp;
        double factor = 1;
        int i = 0;

        while (i < d) {
            factor = factor / 10;
            double tempFactor = factor;

            while ((ans + tempFactor) * (ans + tempFactor) < n) {
                tempFactor += factor;
            }
            ans = ans + tempFactor - factor;
            i++;
        }

        return ans;
    }

    public static double squareRoot(long n, int d) {
        // Write your code here.
        long start = 0;
        long end = n;
        long ans = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (mid * mid <= n) {
                ans = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return solve(ans, n, d);
    }
}