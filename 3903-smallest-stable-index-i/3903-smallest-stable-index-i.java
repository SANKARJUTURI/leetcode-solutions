class Solution 
{
    public int firstStableIndex(int[] nums, int k) 
    {
        int n=nums.length;
        int[][] R=new int[n][2];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[n-i-1]);
            R[i][0]=max;
            R[n-i-1][1]=min;
        }
        int r=k+1;
        for(int i=0;i<n;i++)
        {
            if(R[i][0]-R[i][1]<r)
            {
                return i;
            }
        }
        return -1;
    }
}