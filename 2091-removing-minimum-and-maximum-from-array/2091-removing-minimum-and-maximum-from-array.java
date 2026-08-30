class Solution 
{
    public int minimumDeletions(int[] nums) 
    {
        int n=nums.length;
        int min=0,max=0;
        for(int i=1;i<n;i++) 
        {
            if(nums[i]<nums[min])min=i;
            if(nums[i]>nums[max])max=i;
        }
        int l=Math.min(min,max);
        int r= Math.max(min,max);
        int r1=r+1;      
        int r2=n-l;      
        int r3=(l+1)+(n-r);
        return Math.min(r1,Math.min(r2,r3));
    }
}