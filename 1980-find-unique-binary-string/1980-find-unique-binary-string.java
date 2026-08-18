class Solution 
{
    String res;
    boolean flag;
    public String findDifferentBinaryString(String[] nums) 
    {
        res="";
        flag=false;
        Set<String>S=new HashSet<>();
        for(String str:nums)
        {
            S.add(str);
        }
        backtrack("",S);
        return res;
    }
    private void backtrack(String s,Set<String>S)
    {
        if(flag)return;
        if(s.length()==S.size())
        {
            if(!S.contains(s))
            {
                res=res+s;
                flag=true;
            }
            return;
        }
        backtrack(s+"1",S);
        backtrack(s+"0",S);
    }
}