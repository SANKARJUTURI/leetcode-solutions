class Solution 
{
    public int minAddToMakeValid(String s) 
    {
        int res=0;
        Stack<Character>S=new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(ch=='(')S.push(ch);
            else
            {
                if(S.isEmpty())res++;
                else S.pop();
            }
        }
        return res+S.size();
    }
}