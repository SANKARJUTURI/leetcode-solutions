class Solution 
{
    public String shortestBeautifulSubstring(String s, int k) 
    {
        String res="";
        int c=0;
        int n=s.length();
        int left=0;
        int len=n+1;
        for(int right=0;right<n;right++)
        {
            if(s.charAt(right)=='1')
            {
                c++;
                if(c==k)
                {
                    while(s.charAt(left)!='1')left++;
                    int l=right-left+1;
                    if(l<len)
                    {
                        res=s.substring(left,right+1);
                        len=l;
                    }
                    if(l==len && res.compareTo(s.substring(left,right+1))>0)
                    {
                        res=s.substring(left,right+1);
                    }
                    c--;
                    left++;
                    while(left<right && s.charAt(left)!='1')left++;
                }
            }
        }
        return res;
    }
}