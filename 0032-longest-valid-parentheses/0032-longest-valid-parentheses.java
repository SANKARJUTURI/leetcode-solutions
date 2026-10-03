class Solution 
{
    public int longestValidParentheses(String s) 
    {
        Stack<Integer>S=new Stack<>();
        S.push(-1);
        int n=s.length(),r=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            {
                S.push(i);
            }
            else
            {
                S.pop();
                if(S.isEmpty())
                {
                    S.push(i);
                }
                else
                {
                    r=Math.max(r,i-S.peek());
                }
            }
        }
        return r;
    }
}