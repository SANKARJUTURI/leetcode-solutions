class Solution 
{
    public int missingInteger(int[] nums) 
    {
        Set<Integer>S=new HashSet<>();
        for(int i:nums)
        {
            S.add(i);
        }
        int p=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1]+1)p+=nums[i];
            else break;
        }
        while(true)
        {
            if(S.contains(p))p++;
            else return p;
        }
    }
}