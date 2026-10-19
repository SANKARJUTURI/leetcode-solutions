class Solution 
{
    public List<Integer> targetIndices(int[] nums, int target) 
    {
        List<Integer>L=new ArrayList<>();
        TreeMap<Integer,Integer>T=new TreeMap<>();
        for(int i:nums)
        {
            T.put(i,T.getOrDefault(i,0)+1);
        }
        int start=0;
        for(int i:T.keySet())
        {
            if(i<target)start+=T.get(i);
            else if(i==target)
            {
                for(int j=0;j<T.get(i);j++)
                {
                    L.add(start+j);
                }
                return L;
            }
            else break;
        }
        return L;
    }
}