class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    int A[]={i,j};
                    return A;
                }
            }
        }
        int A[]={-1,-1};
        return A;
        
    }
}