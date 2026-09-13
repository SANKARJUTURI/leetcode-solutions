class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

        java.util.ArrayList<int[]> a = new java.util.ArrayList<>();
        java.util.ArrayList<int[]> b = new java.util.ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) a.add(new int[]{i, j});
                if (img2[i][j] == 1) b.add(new int[]{i, j});
            }
        }

        int ans = 0;

        for (int[] p : a) {
            for (int[] q : b) {
                int dx = q[0] - p[0];
                int dy = q[1] - p[1];

                String key = dx + "," + dy;
                int count = map.getOrDefault(key, 0) + 1;

                map.put(key, count);
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}