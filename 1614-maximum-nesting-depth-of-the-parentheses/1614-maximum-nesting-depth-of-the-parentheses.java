class Solution 
{
    public int maxDepth(String s) 
    {
        int res=0;
        int p=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='(')p++;
            if(ch==')')p--;
            res=Math.max(res,p);
        }
        return res;
    }
}