class Solution 
{
    public int findPoisonedDuration(int[] timeSeries, int duration) 
    {
        int prev=-1;
        int next=-1;
        int res=0;
        for(int t:timeSeries)
        {
            if(t<=next)
            {
                res+=(t-prev);
            }
            else
            {
                res+=duration;
            }
            prev=t;
            next=t+duration;
        }
        return res;
    }
}