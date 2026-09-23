class Solution 
{
    public int minOperations(int[] nums, int x) 
    {
        int t=0;
        for(int i:nums) 
        {
            t+=i;
        }
        int target=t-x;
        if(target<0)return -1;
        if(target==0)return nums.length;
        int l=0;
        int sum=0;
        int maxLen=-1;
        for(int r=0;r<nums.length;r++) 
        {
            sum+=nums[r];
            while(sum>target) 
            {
                sum-=nums[l++];
            }
            if(sum==target) 
            {
                maxLen=Math.max(maxLen,r-l+1);
            }
        }
        return maxLen==-1?-1:nums.length-maxLen;
    }
}