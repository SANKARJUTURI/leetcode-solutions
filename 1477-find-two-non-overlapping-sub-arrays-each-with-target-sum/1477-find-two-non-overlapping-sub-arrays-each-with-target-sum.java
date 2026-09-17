class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        int ans = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        int INF = n + 1;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (i > 0) {
                best[i] = best[i - 1];
            } else {
                best[i] = INF;
            }

            if (sum == target) {
                int len = i - left + 1;

                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                best[i] = Math.min(best[i], len);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}