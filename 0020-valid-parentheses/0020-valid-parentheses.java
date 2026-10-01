class Solution 
{
    public boolean isValid(String s) 
    {
        if(s.length()%2!=0)return false;
        Stack<Character>S=new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(ch=='(' || ch=='{' || ch=='[')
            {
                S.push(ch);
            }
            else if(ch==')')
            {
                if(!S.isEmpty() && S.peek()=='(')S.pop();
                else return false;
            }
            else if(ch=='}')
            {
                if(!S.isEmpty() && S.peek()=='{')S.pop();
                else return false;
            }
            else
            {
                if(!S.isEmpty() && S.peek()=='[')S.pop();
                else return false;
            }
        }
        return S.size()==0;
    }
}