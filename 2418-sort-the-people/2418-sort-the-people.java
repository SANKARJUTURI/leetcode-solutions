class Solution 
{
    public String[] sortPeople(String[] names, int[] heights) 
    {
        TreeMap<Integer,String>M=new TreeMap<>(Collections.reverseOrder());
        int n=names.length;
        for(int i=0;i<n;i++)
        {
            M.put(heights[i],names[i]);
        }
        String[] res=new String[n];
        int k=0;
        for(int i:M.keySet())
        {
            res[k++]=M.get(i);
        }
        return res;
    }
}