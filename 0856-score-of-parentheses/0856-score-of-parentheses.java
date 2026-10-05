class Solution 
{
    public int scoreOfParentheses(String s) 
    {
        int res=0;
        int d=0;
        char prev=' ';
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
                d++;
            }
            else 
            {
                d--;
                if(prev=='(')
                {
                    res+=(1<<d);
                }
            }
            prev=ch;
        }
        return res;
    }
}