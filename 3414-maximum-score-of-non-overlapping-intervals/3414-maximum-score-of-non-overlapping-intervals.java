class Solution {
    static class Node {
        int l, r, w, idx;

        Node(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        Node[] a = new Node[n];

        for (int i = 0; i < n; i++) {
            a[i] = new Node(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(a, (x, y) -> {
            if (x.r != y.r) return Integer.compare(x.r, y.r);
            return Integer.compare(x.l, y.l);
        });

        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int lo = 0, hi = i - 1, ans = -1;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;

                if (a[mid].r < a[i].l) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            prev[i] = ans;
        }

        List<Integer>[][] dp = new ArrayList[n + 1][5];
        long[][] score = new long[n + 1][5];

        for (int i = 0; i <= n; i++)
            Arrays.fill(score[i], -1);

        for (int k = 0; k <= 4; k++) {
            dp[0][k] = new ArrayList<>();
            score[0][k] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new ArrayList<>(dp[i - 1][k]);
                score[i][k] = score[i - 1][k];

                if (k > 0) {
                    int p = prev[i - 1] + 1;

                    long newScore = score[p][k - 1] + a[i - 1].w;
                    List<Integer> candidate = new ArrayList<>(dp[p][k - 1]);
                    candidate.add(a[i - 1].idx);
                    Collections.sort(candidate);

                    if (newScore > score[i][k] ||
                        (newScore == score[i][k] &&
                         lexicographicallySmaller(candidate, dp[i][k]))) {
                        score[i][k] = newScore;
                        dp[i][k] = candidate;
                    }
                }
            }
        }

        List<Integer> ans = dp[n][4];
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    static boolean lexicographicallySmaller(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i)))
                return a.get(i) < b.get(i);
        }
        return a.size() < b.size();
    }
}