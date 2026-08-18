class Solution 
{
    public int largestInteger(int[] nums, int k) 
    {
        Map<Integer,Integer>M=new HashMap<>();
        for(int i=0;i<=nums.length-k;i++)
        {
            Set<Integer>S=new HashSet<>();
            for(int j=i;j<i+k;j++)
            {
                S.add(nums[j]);
            }
            for(int s:S)
            {
                M.put(s,M.getOrDefault(s,0)+1);
            }
        }
        int res=-1;
        for(int i:M.keySet())
        {
            if(M.get(i)==1)res=Math.max(res,i);
        }
        return res;
    }
}