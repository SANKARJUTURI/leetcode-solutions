public class Solution 
{
    public List<String> generateParenthesis(int n) 
    {
        List<String>R=new ArrayList<>();
        backtrack(R,"",0,0,n);
        return R;
    }
    private void backtrack(List<String>R,String curr,int open,int close,int n) 
    {
        if(curr.length()==2*n) 
        {
            R.add(curr);
            return;
        }
        if(open<n) 
        {
            backtrack(R,curr+"(",open+1,close,n);
        }
        if(close<open) 
        {
            backtrack(R,curr+")",open,close+1,n);
        }
    }
}