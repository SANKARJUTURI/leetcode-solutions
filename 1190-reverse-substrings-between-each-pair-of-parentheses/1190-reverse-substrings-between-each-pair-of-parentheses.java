class Solution 
{
    public String reverseParentheses(String s) 
    {
        Stack<Character>S=new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(ch!=')')
            {
                S.push(ch);
            }
            else
            {
                Queue<Character>temp=new LinkedList<>();
                while(S.peek()!='(')
                {
                    temp.offer(S.pop());
                }
                S.pop();
                while(!temp.isEmpty())
                {
                    S.push(temp.poll());
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!S.isEmpty())
        {
            sb.append(S.pop());
        }
        return sb.reverse().toString();
    }
}