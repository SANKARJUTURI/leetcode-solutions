
class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans=0;
        for(int i=0;i<n;i++){
            boolean[] vis = new boolean[101];
            int curr = 0;
            for(int j=i;j<n;j++){
                int val = nums.get(j);
                if(!vis[val]){
                    curr++;
                    vis[val] = true;
                }
                ans += curr*curr;
            }

        }
        return ans;
    }
}