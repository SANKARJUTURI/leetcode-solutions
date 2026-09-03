class Solution 
{
    public boolean uniformArray(int[] nums1) 
    {
        int min=Integer.MAX_VALUE;
        boolean hasOdd=false;
        boolean hasEven=false;
        for(int x:nums1) 
        {
            min=Math.min(min,x);
            if(x%2==0)hasEven=true;
            else hasOdd=true;
        }
        if(!hasOdd || !hasEven)return true;
        return min%2!=0;
    }
}
