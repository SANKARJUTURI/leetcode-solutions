class Solution 
{
    public int distinctSubseqII(String s) 
    {
        int MOD=1000000007;
        long[] dp=new long[s.length() + 1];
        long[] last=new long[26];
        dp[0]=1;
        for(int i = 0; i < s.length(); i++) 
        {
            int c=s.charAt(i)-'a';
            dp[i+1]=(2*dp[i]-last[c]+MOD)%MOD;
            last[c]=dp[i];
        }
        return (int)((dp[s.length()]-1+MOD)%MOD);
    }
}
