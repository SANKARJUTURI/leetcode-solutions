class Solution 
{
    public int minOperations(int[] nums) 
    {
        int n=nums.length;
        if(n==1)return 0;
        int s=0;
        while(nums[s]!=0)
        {
            s++;
        }
        boolean a=true,d=true;
        for(int i=1;i<n;i++)
        {
            int v=nums[(s+i)%n];
            if(v!=i)a=false;
            if(v!=n-i)d=false;
            if(!(a || d))return -1;
        }
        if(a)return Math.min(s,n-s+2);
        return Math.min(n-s,s+2);
    }
}