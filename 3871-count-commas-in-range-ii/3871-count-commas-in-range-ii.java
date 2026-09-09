class Solution 
{
    public long countCommas(long n) 
    {
        if(n<1000)return 0;
        long res=0;
        if(n>=1000_000L)res+=999000;
        else return n-999;
        if(n>=1000_000_000L)res+=(999000000L*2);
        else return res+(n-999999)*2;
        if(n>=1000_000_000_000L)res+=(999000000000L*3);
        else return res+(n-999999999L)*3;
        res+=(n-999999999999L)*4;
        if(n==1000_000_000_000_000L)res++;
        return res;
    }
}