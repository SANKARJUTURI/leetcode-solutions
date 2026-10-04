class Solution 
{
    public boolean checkValidString(String s) 
    {
        int l=0,h=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
                l++;
                h++;
            }
            else if(ch==')')
            {
                if(l>0)l--;
                h--;
            }
            else
            {
                if(l>0)l--;
                h++;
            }
            if(h<0)return false;
        }
        return l==0;
    }
}