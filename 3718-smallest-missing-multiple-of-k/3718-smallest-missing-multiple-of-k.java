class Solution 
{
    public int missingMultiple(int[] nums, int k) 
    {
        HashSet<Integer>S=new HashSet<>();
        for(int i:nums)if(i%k==0)S.add(i);
        int f=k;
        while(true)
        {
            if(!S.contains(f))return f;
            f+=k;
        }
    }
}