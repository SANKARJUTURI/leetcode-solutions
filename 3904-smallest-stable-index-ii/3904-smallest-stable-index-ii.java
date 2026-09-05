class Solution 
{
    public int firstStableIndex(int[] nums, int k) 
    {
        int n=nums.length;
        int[][] mm=new int[n][2];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[n-i-1]);
            mm[i][0]=max;
            mm[n-i-1][1]=min;
        }
        for(int i=0;i<n;i++)
        {
            if(mm[i][0]-mm[i][1]<=k)return i;
        }
        return -1;
    }
}