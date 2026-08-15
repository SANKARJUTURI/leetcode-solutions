class Solution 
{
    public int longestSubsequence(int[] nums) 
    {
        int n=nums.length;
        int xor=0;
        boolean allZero=true;
        for(int i:nums)
        {
            xor^=i;
            if(i!=0)allZero=false;
        }
        if(allZero)return 0;
        return xor==0?n-1:n;
    }
}