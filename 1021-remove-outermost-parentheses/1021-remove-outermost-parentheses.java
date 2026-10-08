class Solution 
{
    public String removeOuterParentheses(String s) 
    {
        int open=1;
        int close=0;
        StringBuilder sb=new StringBuilder();
        int start=0;
        int n=s.length();
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)=='(')
            {
                open++;
            }
            else
            {
                close++;
                if(open==close)
                {
                    open=0;
                    close=0;
                    sb.append(s.substring(start+1,i));
                    start=i+1;
                }
            }
        }
        return sb.toString();
    }
}