class Solution 
{
    public int maximumLengthSubstring(String s) 
    {
        int[] F=new int[26];
        int n=s.length();
        int left=0;
        int res=0;
        for(int right=0;right<n;right++)
        {
            int f=F[s.charAt(right)-'a'];
            if(f==2)
            {
                while(s.charAt(left)!=s.charAt(right))
                {
                    F[s.charAt(left)-'a']--;
                    left++;
                }
                F[s.charAt(left)-'a']--;
                left++;
            }
            F[s.charAt(right)-'a']++;
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}